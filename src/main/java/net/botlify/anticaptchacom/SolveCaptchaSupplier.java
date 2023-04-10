package net.botlify.anticaptchacom;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import net.botlify.anticaptchacom.request.SolveRequest;
import net.botlify.anticaptchacom.response.solution.SolveResponse;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

import java.io.IOException;
import java.util.function.Supplier;

/**
 * A {@link SolveCaptchaSupplier} is a {@link Supplier} of {@link SolveResponse}.
 * This is used to solve a captcha.
 */
@Log4j2
public final class SolveCaptchaSupplier<R> implements Supplier<SolveResponse<R>> {

    /**
     * The API to use for solving the captcha.
     */
    @NotNull @Getter(AccessLevel.PACKAGE)
    private final AntiCaptchaComAPI api;

    /**
     * The request to solve the captcha.
     */
    @NotNull @Getter
    private final SolveRequest request;

    /**
     * Construct a new {@link SolveCaptchaSupplier}.
     * @param api The API to use for solving the captcha.
     * @param request The request to solve the captcha.
     */
    SolveCaptchaSupplier(@NotNull final AntiCaptchaComAPI api,
                         @NotNull final SolveRequest request) {
        this.api = api;
        this.request = request;
    }

    @Override
    @SneakyThrows({AntiCaptchaComException.class, IOException.class})
    public @NotNull SolveResponse<R> get() {
        return (solve());
    }

    public @NotNull SolveResponse<R> solve() throws AntiCaptchaComException, IOException {
        final OkHttpClient client = new OkHttpClient.Builder()
                .build();
        final Integer taskId = startTask(client);


        return (getCaptchaSolution(client, taskId, 0));
    }

    /**
     * This method start the task on the anti-captcha.com API only
     * for the captcha type RECAPTCHA_V2. (Proxyless)
     * @param client The HTTP client.
     * @return The task id.
     */
    private @NotNull Integer startTask(@NotNull final OkHttpClient client) throws AntiCaptchaComException, IOException {
        log.debug("Start task on anti-captcha.com");
        final JSONObject requestJson = new JSONObject();
        requestJson.put("clientKey", api.getConfig().getApiKey());
        requestJson.put("task", request.requestJson());
        requestJson.put("softId", api.getConfig().getSoftId());

        final String responseString = api.sendPost(client, "https://api.anti-captcha.com/createTask", request);
        final JSONObject responseJson = new JSONObject(responseString);

        log.trace("Request response start task on anti-captcha.com: {}", responseJson);
        if (responseJson.getInt("errorId") != 0) {
            log.warn("Error while starting task on anti-captcha.com: {}", responseJson.getString("errorDescription"));
            return (null);
        }
        return (responseJson.getInt("taskId"));
    }

    /**
     * This method request the captcha solution on the anti-captcha.com API
     * for the task id given in parameter.
     * @param taskId The task id.
     * @return The captcha solution.
     */
    @SneakyThrows({InterruptedException.class})
    private @Nullable SolveResponse<R> getCaptchaSolution(@NotNull final OkHttpClient client,
                                                          @NotNull final Integer taskId,
                                                          final int attempt) throws AntiCaptchaComException, IOException {
        if (attempt > api.getConfig().getMaxAttempts()) {
            log.warn("Max attempts reached for anti-captcha.com for task id {}", taskId);
            return (null);
        }
        final JSONObject request = new JSONObject();
        request.put("clientKey", api.getConfig().getApiKey());
        request.put("taskId", taskId);
        Thread.sleep(api.getConfig().getSleepBetweenAttemptsMillis());

        final String responseString = api.sendPost(client, "https://api.anti-captcha.com/getTaskResult", request);
        final JSONObject responseJson = new JSONObject(responseString);

        if (responseJson.getInt("errorId") != 0) {
            log.warn("Error while getting captcha solution from anti-captcha.com: {}", responseJson.getString(
                    "errorDescription"));
            return (null);
        }
        if (responseJson.getString("status").equals("processing")) {
            log.trace("Attempt {}/{}: captcha solution not ready yet on anti-captcha.com with task id {}," +
                            " waiting {} millis before retrying...",
                    attempt, api.getConfig().getMaxAttempts(), taskId, api.getConfig().getSleepBetweenAttemptsMillis());
            return (getCaptchaSolution(client, taskId, attempt + 1));
        }
        return (null);
        // return (responseJson.getJSONObject("solution").getString("gRecaptchaResponse"));
    }

}
