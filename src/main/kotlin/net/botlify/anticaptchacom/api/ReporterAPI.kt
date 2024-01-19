package net.botlify.anticaptchacom.api

import net.botlify.anticaptchacom.AntiCaptchaComClient
import net.botlify.anticaptchacom.exceptions.AntiCaptchaComException
import okhttp3.OkHttpClient
import java.io.IOException

/**
 * This class is used to report incorrect captchas.
 */
@Deprecated("Not implemented yet.")
class ReporterAPI
/**
 * Construct a new [ReporterAPI].
 * @param api The API to use.
 */(
    /**
     * The API to use for reporting.
     */
    private val api: AntiCaptchaComClient
) {
    /**
     * The report should be executed within 60 seconds after the task is completed.
     * @param taskId The task ID.
     * @see [Documentation](https://anti-captcha.com/apidoc/methods/reportIncorrectImageCaptcha)
     *
     * @throws AntiCaptchaComException If the API returns an error.
     * @throws IOException If an I/O error occurs.
     */
    @Throws(AntiCaptchaComException::class, IOException::class)
    fun reportIncorrectImageCaptcha(taskId: Int) {
        sendReport("/reportIncorrectImageCaptcha", taskId)
    }

    /**
     * The report should be executed within 60 seconds after the task is completed.
     * @param taskId The task ID.
     * @see [Documentation](https://anti-captcha.com/apidoc/methods/reportIncorrectRecaptcha)
     *
     * @throws AntiCaptchaComException If the API returns an error.
     * @throws IOException If an I/O error occurs.
     */
    @Throws(AntiCaptchaComException::class, IOException::class)
    fun reportIncorrectRecaptcha(taskId: Int) {
        sendReport("reportIncorrectRecaptcha", taskId)
    }

    /**
     * The report should be executed within 60 seconds after the task is completed.
     * @param taskId The task ID.
     * @see [Documentation](https://anti-captcha.com/apidoc/methods/reportCorrectRecaptcha)
     *
     * @throws AntiCaptchaComException If the API returns an error.
     * @throws IOException If an I/O error occurs.
     */
    @Throws(AntiCaptchaComException::class, IOException::class)
    fun reportCorrectRecaptcha(taskId: Int) {
        sendReport("/reportCorrectRecaptcha", taskId)
    }

    /**
     * The report should be executed within 60 seconds after the task is completed.
     * @param taskId The task ID.
     * @see [Documentation](https://anti-captcha.com/apidoc/methods/reportIncorrectHcaptcha)
     *
     * @throws AntiCaptchaComException If the API returns an error.
     * @throws IOException If an I/O error occurs.
     */
    @Throws(AntiCaptchaComException::class, IOException::class)
    fun reportIncorrectHCaptcha(taskId: Int) {
        sendReport("/reportIncorrectHcaptcha", taskId)
    }

    // Private methods
    /**
     * Send the report to the API.
     * @param path The path to the API.
     * @param taskId The task ID.
     * @throws AntiCaptchaComException If the API returns an error.
     * @throws IOException If an I/O error occurs.
     */
    // @Throws(AntiCaptchaComException.class, IOException.class)
    @Throws(AntiCaptchaComException::class, IOException::class)
    private fun sendReport(
        path: String,
        taskId: Int
    ) {
        // val client: OkHttpClient = Builder()
        //     .build()
        // final String url = api..getApiUrl() + path;
        // final JSONObject jsonObject = new JSONObject();
        // jsonObject.put("clientKey", api.getConfig().getApiKey());
        // jsonObject.put("taskId", taskId);
        // api.getHttpRequester().sendPost(client, url, jsonObject);
    }
}
