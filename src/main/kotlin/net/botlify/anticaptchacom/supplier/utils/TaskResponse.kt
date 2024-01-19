package net.botlify.anticaptchacom.supplier.utils

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import net.botlify.anticaptchacom.API_URL
import net.botlify.anticaptchacom.AntiCaptchaComClient
import net.botlify.anticaptchacom.data.response.solution.SolveResponse
import net.botlify.anticaptchacom.enums.TaskStatus
import net.botlify.anticaptchacom.exceptions.AntiCaptchaComException
import org.apache.logging.log4j.LogManager
import java.util.concurrent.TimeoutException

@JsonIgnoreProperties(ignoreUnknown = true)
private data class TaskResult(
    @JsonProperty("errorId")
    val errorId: Int,
    @JsonProperty("status")
    val status: TaskStatus,
)

private data class TaskRequest(
    @JsonProperty("clientKey")
    val clientKey: String,
    @JsonProperty("taskId")
    val taskId: TaskId,
)

internal class TaskResponse<T>(
    private val api: AntiCaptchaComClient,
    private val taskId: TaskId,
    private val clazz: Class<T>,
) {

    companion object {
        /**
         * The logger of the class.
         */
        private val log = LogManager.getLogger(TaskResponse::class.java)
    }

    @Throws(AntiCaptchaComException::class, TimeoutException::class)
    fun getResponse(): SolveResponse<T> {
        return (getResponse(0))
    }

    private fun getResponse(attempt: Int): SolveResponse<T> {
        verifyAttemptAndSleep(attempt)

        val responseString = sendGetStatus()
        val taskResult = mapTaskResult(responseString)

        return when (taskResult.status) {
            TaskStatus.PROCESSING -> {
                getResponse(attempt + 1)
            }
            TaskStatus.READY -> {
                mapResponse(responseString)
            }
        }
    }

    private fun verifyAttemptAndSleep(attempt: Int) {
        val firstSleepTime = api.config.firstSleepBetweenAttemptsMillis
        val otherSleepTime = api.config.sleepBetweenAttemptsMillis
        val sleepTime = if (attempt == 0) firstSleepTime else otherSleepTime
        val maxAttempts = api.config.maxAttempts;
        if (attempt > maxAttempts) {
            throw TimeoutException("Max attempts reached for anti-captcha.com for task id $taskId")
        }
        log.trace("Sleeping {} millis before getting captcha solution for task id {}...", sleepTime, taskId)
        Thread.sleep(sleepTime.toLong())
    }

    private fun sendGetStatus(): String {
        val mapper = jacksonObjectMapper()
        val request = TaskRequest(api.config.apiKey, taskId)
        val requestJson = mapper.writeValueAsString(request)
        val responseString: String = api.httpRequester.sendPost("$API_URL/getTaskResult", requestJson)
        return responseString;
    }

    private fun mapTaskResult(json: String): TaskResult {
        val mapper = jacksonObjectMapper()
        val result = mapper.readValue(json, TaskResult::class.java)
        return result
    }

    private fun mapResponse(response: String): SolveResponse<T> {
        val mapper = jacksonObjectMapper()
        val type = mapper.typeFactory.constructParametricType(SolveResponse::class.java, clazz)
        val result = mapper.readValue<SolveResponse<T>>(response, type)
        return result
    }

}