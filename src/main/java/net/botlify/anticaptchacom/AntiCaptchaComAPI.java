package net.botlify.anticaptchacom;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import net.botlify.anticaptchacom.enums.CaptchaServiceType;
import net.botlify.anticaptchacom.exceptions.AntiCaptchaComException;
import net.botlify.anticaptchacom.response.QueueStatsResponse;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.io.IOException;

/**
 * The {@link AntiCaptchaComAPI} is the main class to use to 
 * solve captcha with anti-captcha.com.
 */
@EqualsAndHashCode
@ToString
@Log4j2
public final class AntiCaptchaComAPI {

    @NotNull @Getter
    private static final String apiUrl = "https://api.anti-captcha.com";

    @NotNull @Getter(AccessLevel.PACKAGE)
    private final AntiCaptchaComConfig config;

    /**
     * Construct a new {@link AntiCaptchaComAPI}.
     * @param config The configuration.
     */
    public AntiCaptchaComAPI(@NotNull final AntiCaptchaComConfig config) {
        this.config = config;
    }

    /*
     $      Public methods
     */

    /**
     * This method return the {@link ReporterAPI} to use
     * to notify the AntiCaptcha.com team about the captchas
     * that are not valid or valid.
     * @return The {@link ReporterAPI}.
     */
    public @NotNull ReporterAPI getReporterAPI() {
        return (new ReporterAPI(this));
    }

    public @NotNull AccountAPI getAccountAPI() {
        return (new AccountAPI(this));
    }

    public @NotNull SolverAPI getSolverAPI() {
        return (new SolverAPI(this));
    }

    /*
     $      Private methods
     */

    /**
     * This method send a POST request to the url given in parameter.
     * @param url The url.
     * @param body The body as a JSON object.
     * @return The response.
     */
    @NotNull String sendPost(@NotNull final OkHttpClient client,
                             @NotNull final String url,
                             @NotNull final Object body) throws IOException, AntiCaptchaComException {

        final Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(body.toString(), MediaType.parse("application/json")))
                .build();
        try (final Response response = client.newCall(request).execute()) {
            final String responseBody = response.body().string();
            final int code = response.code();
            verifyRequest(code, responseBody);
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
    @NotNull String sendGet(@NotNull final OkHttpClient client,
                            @NotNull final String url) throws AntiCaptchaComException, IOException {
        final Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        try (final Response response = client.newCall(request).execute()) {
            final String responseBody = response.body().string();
            final int code = response.code();
            verifyRequest(code, responseBody);
            return (responseBody);
        }
    }

    /**
     * Verifies that the request was successful.
     * @param code The code of the response.
     * @param body The body of the response.
     * @throws AntiCaptchaComException If the request was not successful.
     */
    public void verifyRequest(final int code,
                              @NotNull final String body) throws AntiCaptchaComException {
        // If code is between 0 and 399, the request was successful.
        if (code >= 0 && code <= 399)
            return;
        throw (new AntiCaptchaComException(code, body));
    }

    // static functions

    public static @NotNull QueueStatsResponse getQueueStats(@NotNull final CaptchaServiceType type) throws IOException {
        final OkHttpClient client = new OkHttpClient();
        final JSONObject body = new JSONObject();
        body.put("queueId", type.getValue());

        final Request request = new Request.Builder()
                .url(getApiUrl() + "/getQueueStats")
                .post(RequestBody.create(body.toString(), MediaType.parse("application/json")))
                .build();
        try (final Response response = client.newCall(request).execute()) {
            final String responseBody = response.body().string();
            final ObjectMapper mapper = new ObjectMapper();
            return (mapper.readValue(responseBody, QueueStatsResponse.class));
        }
    }

}
