package net.botlify.anticaptchacom

import net.botlify.anticaptchacom.api.AccountAPI
import net.botlify.anticaptchacom.api.ReporterAPI
import net.botlify.anticaptchacom.api.SolverAPI

/**
 * The [AntiCaptchaComClient] is the main class to use to
 * solve captcha with anti-captcha.com.
 */
class AntiCaptchaComClient internal constructor(
    internal val config: AntiCaptchaComBuilder
) {

    internal val httpRequester = HttpRequester()

    /**
     * This method return the [ReporterAPI] to use
     * to notify the AntiCaptcha.com team about the captchas
     * that are not valid or valid.
     *
     * @return The [ReporterAPI].
     */
    val reporterAPI by lazy { ReporterAPI(this) }

    /**
     * This method return the [AccountAPI] to use
     * to get information about the account use via the API key.
     *
     * @return The [AccountAPI].
     */
    val accountApi by lazy { AccountAPI(this) }

    /**
     * This method return the [SolverAPI] to use
     * to solve captcha.
     *
     * @return The [SolverAPI].
     */
    val solverAPI by lazy { SolverAPI(this) }

    /*
    companion object {
        @Getter
        private val apiUrl = "https://api.anti-captcha.com"

        // Static functions
        @Throws(IOException::class)
        fun getQueueStats(type: CaptchaServiceType): QueueStatsResponse {
            val client = OkHttpClient()
            val body = JSONObject()
            body.put("queueId", type.value)

            val request: Request = Builder()
                .url(AntiCaptchaComAPI.getApiUrl() + "/getQueueStats")
                .post(create.create(body.toString(), parse.parse("application/json")))
                .build()
            client.newCall(request).execute().use { response ->
                val responseBody = response.body().string()
                val mapper = ObjectMapper()
                return (mapper.readValue(responseBody, QueueStatsResponse::class.java))
            }
        }
    }
    */
}
