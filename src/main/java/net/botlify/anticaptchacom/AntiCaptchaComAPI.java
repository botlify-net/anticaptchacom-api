package net.botlify.anticaptchacom;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

import java.io.IOException;

/**
 * The {@link AntiCaptchaComAPI} is the main class to use to 
 * solve captchas with anti-captcha.com.
 */
@Log4j2
public class AntiCaptchaComAPI {

    @NotNull @Getter(AccessLevel.PACKAGE)
    private final AntiCaptchaComConfig config;

    /**
     * Construct a new {@link AntiCaptchaComAPI}.
     * @param config The configuration.
     */
    public AntiCaptchaComAPI(@NotNull final AntiCaptchaComConfig config) {
        this.config = config;
    }

    // Public methods

    /**
     * Start a task on anti-captcha.com.
     * @param captchaKey The captcha key.
     * @param captchaUrl The captcha url.
     * @param captchaType The captcha type.
     * @return The solution of the captcha.
     * @throws AntiCaptchaComException If an error occurs.
     * @throws IOException If an error occurs.
     */
    public @Nullable String solve(@NotNull final String captchaKey,
                                  @NotNull final String captchaUrl,
                                  @NotNull final CaptchaType captchaType) throws AntiCaptchaComException, IOException {
        log.debug("Start solving captcha with anti-captcha.com");

        final OkHttpClient client = new OkHttpClient();

        log.trace("API key found for anti-captcha.com");
        if (captchaType != CaptchaType.RECAPTCHA_V2)
            throw (new UnsupportedOperationException("Only recaptcha v2 is supported"));
        final Integer taskId = startTask(client, captchaKey, captchaUrl);
        if (taskId == null) {
            log.warn("Impossible to start task on anti-captcha.com");
            return (null);
        }
        log.debug("Task started on anti-captcha.com with id {}", taskId);
        final String solution = getCaptchaSolution(client, taskId, 1);
        if (solution == null) {
            log.warn("Impossible to get captcha solution from anti-captcha.com");
            return (solve(captchaKey, captchaUrl, captchaType));
        }
        log.debug("Captcha solution found {} on anti-captcha.com with task id {}", solution, taskId);
        return (solution);
    }

    public @NotNull Float getBalance() throws AntiCaptchaComException, IOException {
        final OkHttpClient client = new OkHttpClient();
        final JSONObject body = new JSONObject();
        body.put("clientKey", config.getApiKey());

        final String responseString = sendPost(client, "https://api.anti-captcha.com/getBalance", body);
        final JSONObject responseJson = new JSONObject(responseString);
        return (responseJson.getFloat("balance"));
    }

    // Private methods

    /**
     * This method request the captcha solution on the anti-captcha.com API
     * for the task id given in parameter.
     * @param taskId The task id.
     * @return The captcha solution.
     */
    @SneakyThrows({InterruptedException.class})
    private @Nullable String getCaptchaSolution(@NotNull final OkHttpClient client,
                                                @NotNull final Integer taskId,
                                                final int attempt) throws AntiCaptchaComException, IOException {
        if (attempt > config.getMaxAttempts()) {
            log.warn("Max attempts reached for anti-captcha.com for task id {}", taskId);
            return (null);
        }
        final JSONObject request = new JSONObject();
        request.put("clientKey", config.getApiKey());
        request.put("taskId", taskId);
        Thread.sleep(config.getSleepBetweenAttemptsMillis());

        final String responseString = sendPost(client, "https://api.anti-captcha.com/getTaskResult", request);
        final JSONObject responseJson = new JSONObject(responseString);

        if (responseJson.getInt("errorId") != 0) {
            log.warn("Error while getting captcha solution from anti-captcha.com: {}", responseJson.getString(
                    "errorDescription"));
            return (null);
        }
        if (responseJson.getString("status").equals("processing")) {
            log.trace("Attempt {}/{}: captcha solution not ready yet on anti-captcha.com with task id {}," +
                            " waiting {} millis before retrying...",
                    attempt, config.getMaxAttempts(), taskId, config.getSleepBetweenAttemptsMillis());
            return (getCaptchaSolution(client, taskId, attempt + 1));
        }
        return (responseJson.getJSONObject("solution").getString("gRecaptchaResponse"));
    }

    /**
     * This method start the task on the anti-captcha.com API only
     * for the captcha type RECAPTCHA_V2. (Proxyless)
     * @param client The HTTP client.
     * @param captchaKey The captcha key of the website.
     * @param captchaUrl The captcha url of the website.
     * @return The task id.
     */
    private @Nullable Integer startTask(@NotNull final OkHttpClient client,
                                        @NotNull final String captchaKey,
                                        @NotNull final String captchaUrl) throws AntiCaptchaComException, IOException {
        log.debug("Start task on anti-captcha.com");
        final JSONObject request = new JSONObject();
        request.put("clientKey", config.getApiKey());
        request.put("task", new JSONObject()
                .put("type", "RecaptchaV2TaskProxyless")
                .put("websiteURL", captchaUrl)
                .put("websiteKey", captchaKey));
        request.put("softId", 0);

        final String responseString = sendPost(client, "https://api.anti-captcha.com/createTask", request);
        final JSONObject responseJson = new JSONObject(responseString);

        log.trace("Request response start task on anti-captcha.com: {}", responseJson);
        if (responseJson.getInt("errorId") != 0) {
            log.warn("Error while starting task on anti-captcha.com: {}", responseJson.getString(
                    "errorDescription"));
            return (null);
        }
        return responseJson.getInt("taskId");
    }

    // Request

    /**
     * This method send a POST request to the url given in parameter.
     * @param url The url.
     * @param body The body as a JSON object.
     * @return The response.
     */
    private @NotNull String sendPost(@NotNull final OkHttpClient client,
                                     @NotNull final String url,
                                     @NotNull final Object body) throws IOException, AntiCaptchaComException {

        final Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(body.toString(), MediaType.parse("application/json")))
                .build();
        try (final Response response = client.newCall(request).execute()) {
            final String responseBody = response.body().string();
            final int code = response.code();
            AntiCaptchaComException.verifyRequest(code, responseBody);
            return (responseBody);
        }
    }

    /**
     * This method send a GET request to the url given in parameter.
     * @param client The HTTP client.
     * @param url The url.
     * @return The response as String format.
     * @throws AntiCaptchaComException If the request failed.
     * @throws IOException If the request failed.
     */
    private @NotNull String sendGet(@NotNull final OkHttpClient client,
                                    @NotNull final String url) throws AntiCaptchaComException, IOException {
        final Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        try (final Response response = client.newCall(request).execute()) {
            final String responseBody = response.body().string();
            final int code = response.code();
            AntiCaptchaComException.verifyRequest(code, responseBody);
            return (responseBody);
        }
    }

}
