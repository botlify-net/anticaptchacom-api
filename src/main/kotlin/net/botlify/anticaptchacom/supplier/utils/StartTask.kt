package net.botlify.anticaptchacom.supplier.utils

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import net.botlify.anticaptchacom.AntiCaptchaComClient
import org.apache.logging.log4j.LogManager

typealias TaskId = Int

private data class StartTaskRequest<T>(
    @JsonProperty("clientKey")
    val clientKey: String,

    @JsonProperty("task")
    val task: T,

    @JsonProperty("softId")
    val softId: Int? = null
)

private data class StartTaskResponse(
    @JsonProperty("errorId")
    val errorId: Int,

    @JsonProperty("taskId")
    val taskId: TaskId
)

internal class StartTask<T>(
    private val api: AntiCaptchaComClient,
    private val task: T,
) {

    companion object {
        private val log = LogManager.getLogger(StartTask::class.java)
    }

    fun startTask(): TaskId {
        val mapper = jacksonObjectMapper()
        // Send request
        log.trace("Send request to create task...")
        val request: StartTaskRequest<T> = StartTaskRequest(api.config.apiKey, task, api.config.softId)
        log.trace("Object to send to create task: {}", request)
        val requestJson = mapper.writeValueAsString(request)
        log.trace("Json to send to create task: {}", requestJson)
        val responseString = api.httpRequester.sendPost("/createTask", requestJson)
        // Parse response
        val response = mapper.readValue(responseString, StartTaskResponse::class.java)
        log.trace("Response of create task: {}", response)
        return response.taskId;
    }

}
