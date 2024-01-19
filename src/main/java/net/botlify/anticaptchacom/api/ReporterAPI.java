package net.botlify.anticaptchacom.api;

import net.botlify.anticaptchacom.AntiCaptchaComAPI;
import net.botlify.anticaptchacom.exceptions.AntiCaptchaComException;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.io.IOException;

/**
 * This class is used to report incorrect captchas.
 */
public final class ReporterAPI {

    /**
     * The API to use for reporting.
     */
    @NotNull
    private final AntiCaptchaComAPI api;

    /**
     * Construct a new {@link ReporterAPI}.
     * @param api The API to use.
     */
    public ReporterAPI(@NotNull final AntiCaptchaComAPI api) {
        this.api = api;
    }

    /**
     * The report should be executed within 60 seconds after the task is completed.
     * @param taskId The task ID.
     * @see <a href="https://anti-captcha.com/apidoc/methods/reportIncorrectImageCaptcha">Documentation</a>
     * @throws AntiCaptchaComException If the API returns an error.
     * @throws IOException If an I/O error occurs.
     */
    public void reportIncorrectImageCaptcha(final int taskId) throws AntiCaptchaComException, IOException {
        sendReport("/reportIncorrectImageCaptcha", taskId);
    }

    /**
     * The report should be executed within 60 seconds after the task is completed.
     * @param taskId The task ID.
     * @see <a href="https://anti-captcha.com/apidoc/methods/reportIncorrectRecaptcha">Documentation</a>
     * @throws AntiCaptchaComException If the API returns an error.
     * @throws IOException If an I/O error occurs.
     */
    public void reportIncorrectRecaptcha(final int taskId) throws AntiCaptchaComException, IOException {
        sendReport("reportIncorrectRecaptcha", taskId);
    }

    /**
     * The report should be executed within 60 seconds after the task is completed.
     * @param taskId The task ID.
     * @see <a href="https://anti-captcha.com/apidoc/methods/reportCorrectRecaptcha">Documentation</a>
     * @throws AntiCaptchaComException If the API returns an error.
     * @throws IOException If an I/O error occurs.
     */
    public void reportCorrectRecaptcha(final int taskId) throws AntiCaptchaComException, IOException {
        sendReport("/reportCorrectRecaptcha", taskId);
    }

    /**
     * The report should be executed within 60 seconds after the task is completed.
     * @param taskId The task ID.
     * @see <a href="https://anti-captcha.com/apidoc/methods/reportIncorrectHcaptcha">Documentation</a>
     * @throws AntiCaptchaComException If the API returns an error.
     * @throws IOException If an I/O error occurs.
     */
    public void reportIncorrectHCaptcha(final int taskId) throws AntiCaptchaComException, IOException {
        sendReport("/reportIncorrectHcaptcha", taskId);
    }

    // Private methods

    /**
     * Send the report to the API.
     * @param path The path to the API.
     * @param taskId The task ID.
     * @throws AntiCaptchaComException If the API returns an error.
     * @throws IOException If an I/O error occurs.
     */
    private void sendReport(@NotNull final String path,
                            final int taskId) throws AntiCaptchaComException, IOException {
        final OkHttpClient client = new OkHttpClient.Builder()
                .build();
        final String url = AntiCaptchaComAPI.getApiUrl() + path;
        final JSONObject jsonObject = new JSONObject();
        jsonObject.put("clientKey", api.getConfig().getApiKey());
        jsonObject.put("taskId", taskId);
        api.getHttpRequester().sendPost(client, url, jsonObject);
    }

}
