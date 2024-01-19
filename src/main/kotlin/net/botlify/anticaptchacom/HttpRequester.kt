package net.botlify.anticaptchacom

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import net.botlify.anticaptchacom.enums.AntiCaptchaComError
import net.botlify.anticaptchacom.exceptions.AntiCaptchaComException
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

internal const val API_URL = "https://api.anti-captcha.com"

@JsonIgnoreProperties(ignoreUnknown = true)
private class ErrorId(
    @JsonProperty("errorId")
    val errorId: AntiCaptchaComError,
)

internal class HttpRequester {

    private val client: OkHttpClient = OkHttpClient.Builder()
        .build()

    @Throws(IOException::class, AntiCaptchaComException::class)
    fun sendPost(
        url: String,
        body: String,
    ): String {
        val mapper = jacksonObjectMapper()
        val parse = "application/json".toMediaType();
        val bodyJson = mapper.writeValueAsString(body).toRequestBody(parse);

        val request: Request = Request.Builder()
            .url(url)
            .post(bodyJson)
            .build()
        client.newCall(request).execute().use { response ->
            val responseBody = response.body.string()
            verifyRequest(responseBody)
            return (responseBody)
        }
    }

    @Throws(IOException::class, AntiCaptchaComException::class)
    fun sendGet(
        url: String,
    ): String {
        val request: Request = Request.Builder()
            .url(url)
            .get()
            .build()
        client.newCall(request).execute().use { response ->
            val responseBody = response.body.string()
            verifyRequest(responseBody)
            return (responseBody)
        }
    }

    /**
     * Verifies that the request was successful.
     *
     * @param body The body of the response.
     * @throws AntiCaptchaComException If the request was not successful.
     */
    @Throws(AntiCaptchaComException::class)
    fun verifyRequest(
        body: String
    ) {
        val mapper = jacksonObjectMapper()
        val errorId = mapper.readValue(body, ErrorId::class.java).errorId
        if (errorId == AntiCaptchaComError.NO_ERROR) {
            return
        }
        val responseJson = mapper.readValue(body, AntiCaptchaComException::class.java)
        throw responseJson
    }
}
