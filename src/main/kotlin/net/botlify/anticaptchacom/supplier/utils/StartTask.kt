package net.botlify.anticaptchacom.supplier.utils

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import net.botlify.anticaptchacom.API_URL
import net.botlify.anticaptchacom.AntiCaptchaComClient

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

    fun startTask(): TaskId {
        val mapper = jacksonObjectMapper()
        // Send request
        val request: StartTaskRequest<T> = StartTaskRequest(api.config.apiKey, task, api.config.softId)
        val requestJson = mapper.writeValueAsString(request)
        val responseString = api.httpRequester.sendPost("$API_URL/createTask", requestJson)
        // Parse response
        val response = mapper.readValue<StartTaskResponse>(responseString, StartTaskResponse::class.java)
        return response.taskId;
    }

}
