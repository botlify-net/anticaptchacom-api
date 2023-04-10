package net.botlify.anticaptchacom;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import net.botlify.anticaptchacom.enums.CaptchaServiceType;
import net.botlify.anticaptchacom.request.*;
import net.botlify.anticaptchacom.response.QueueStatsResponse;
import net.botlify.anticaptchacom.response.solution.FunCaptchaSolution;
import net.botlify.anticaptchacom.response.solution.SolveResponse;
import net.botlify.anticaptchacom.response.solution.ImageToTextSolution;
import net.botlify.anticaptchacom.response.solution.RecaptchaSolution;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * The {@link AntiCaptchaComAPI} is the main class to use to 
 * solve captcha with anti-captcha.com.
 */
@EqualsAndHashCode
@ToString
@Log4j2
public final class AntiCaptchaComAPI {

    @NotNull @Getter(AccessLevel.PACKAGE)
    private final AntiCaptchaComConfig config;

    /**
     * Construct a new {@link AntiCaptchaComAPI}.
     * @param config The configuration.
     */
    public AntiCaptchaComAPI(@NotNull final AntiCaptchaComConfig config) {
        this.config = config;
    }

    // Image to text

    public @NotNull SolveResponse<ImageToTextSolution> solve(@NotNull final ImageToTextRequest request)
            throws AntiCaptchaComException, IOException {
        return (solveSynchronized(request));
    }

    public @NotNull CompletableFuture<SolveResponse<ImageToTextSolution>> solveAsync(@NotNull final ImageToTextRequest request) {
        return (this.solveAsynchronous(request));
    }

    // Recaptcha V2

    public @NotNull SolveResponse<RecaptchaSolution> solve(@NotNull final RecaptchaV2Request request)
            throws AntiCaptchaComException, IOException {
        return (solveSynchronized(request));
    }

    public @NotNull CompletableFuture<SolveResponse<RecaptchaSolution>> solveAsync(@NotNull final RecaptchaV2Request request) {
        return (solveAsynchronous(request));
    }

    // Recaptcha V2 Proxy

    public @NotNull SolveResponse<RecaptchaSolution> solve(@NotNull final RecaptchaV2ProxyRequest request)
            throws AntiCaptchaComException, IOException {
        return (solveSynchronized(request));
    }

    public @NotNull CompletableFuture<SolveResponse<RecaptchaSolution>> solveAsync(@NotNull final RecaptchaV2ProxyRequest request) {
        return (solveAsynchronous(request));
    }

    // Recaptcha V2 Enterprise

    public @NotNull SolveResponse<RecaptchaSolution> solve(@NotNull final RecaptchaV2EnterpriseRequest request)
            throws AntiCaptchaComException, IOException {
        return (solveSynchronized(request));
    }

    public @NotNull CompletableFuture<SolveResponse<RecaptchaSolution>> solveAsync(@NotNull final RecaptchaV2EnterpriseRequest request) {
        return (solveAsynchronous(request));
    }

    // Recaptcha V2 Enterprise Proxy

    public @NotNull SolveResponse<RecaptchaSolution> solve(@NotNull final RecaptchaV2EnterpriseProxyRequest request)
            throws AntiCaptchaComException, IOException {
        return (solveSynchronized(request));
    }

    public @NotNull CompletableFuture<SolveResponse<RecaptchaSolution>> solveAsync(@NotNull final RecaptchaV2EnterpriseProxyRequest request) {
        return (solveAsynchronous(request));
    }

    // Recaptcha V3

    public @NotNull SolveResponse<RecaptchaSolution> solve(@NotNull final RecaptchaV3Request request)
            throws AntiCaptchaComException, IOException {
        return (solveSynchronized(request));
    }

    public @NotNull CompletableFuture<SolveResponse<RecaptchaSolution>> solveAsync(@NotNull final RecaptchaV3Request request) {
        return (solveAsynchronous(request));
    }

    // Recaptcha V3 Enterprise

    public @NotNull SolveResponse<RecaptchaSolution> solve(@NotNull final RecaptchaV3EnterpriseRequest request)
            throws AntiCaptchaComException, IOException {
        return (solveSynchronized(request));
    }

    public @NotNull CompletableFuture<SolveResponse<RecaptchaSolution>> solveAsync(@NotNull final RecaptchaV3EnterpriseRequest request) {
        return (solveAsynchronous(request));
    }

    // Fun captcha

    public @NotNull SolveResponse<FunCaptchaSolution> solve(@NotNull final FunCaptchaRequest request)
            throws AntiCaptchaComException, IOException {
        return (solveSynchronized(request));
    }

    public @NotNull CompletableFuture<SolveResponse<FunCaptchaSolution>> solveAsync(@NotNull final FunCaptchaRequest request) {
        return (solveAsynchronous(request));
    }

    // Fun captcha proxy

    public @NotNull SolveResponse<FunCaptchaSolution> solve(@NotNull final FunCaptchaProxyRequest request)
            throws AntiCaptchaComException, IOException {
        return (solveSynchronized(request));
    }

    public @NotNull CompletableFuture<SolveResponse<FunCaptchaSolution>> solveAsync(@NotNull final FunCaptchaProxyRequest request) {
        return (solveAsynchronous(request));
    }

    // GeeTest

    private <T> @NotNull SolveResponse<T> solveSynchronized(@NotNull final SolveRequest solveRequest)
            throws AntiCaptchaComException, IOException {
        final SolveCaptchaSupplier<T> solveCaptcha = new SolveCaptchaSupplier<>(this, solveRequest);
        return (solveCaptcha.solve());

    }

    private <T> @NotNull CompletableFuture<SolveResponse<T>> solveAsynchronous(@NotNull final SolveRequest solveRequest) {
        final SolveCaptchaSupplier<T> solveCaptcha = new SolveCaptchaSupplier<>(this, solveRequest);
        return CompletableFuture.supplyAsync(solveCaptcha);
    }

    // Account information

    /**
     * This method return the balance of the account.
     * @return The balance.
     * @throws AntiCaptchaComException If the request failed.
     * @throws IOException If an I/O error occurred.
     */
    public @NotNull Float getBalance() throws AntiCaptchaComException, IOException {
        final OkHttpClient client = new OkHttpClient();
        final JSONObject body = new JSONObject();

        body.put("clientKey", config.getApiKey());

        final String responseString = sendPost(client, "https://api.anti-captcha.com/getBalance", body);
        final JSONObject responseJson = new JSONObject(responseString);
        return (responseJson.getFloat("balance"));
    }

    // Request

    /**
     * This method send a POST request to the url given in parameter.
     * @param url The url.
     * @param body The body as a JSON object.
     * @return The response.
     */
    @NotNull String sendPost(@NotNull final OkHttpClient client, @NotNull final String url, @NotNull final Object body) throws IOException, AntiCaptchaComException {

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
    @NotNull String sendGet(@NotNull final OkHttpClient client,
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

    // static functions

    @SneakyThrows(IOException.class)
    public static @NotNull QueueStatsResponse getQueueStats(@NotNull final CaptchaServiceType type) {
        final OkHttpClient client = new OkHttpClient();
        final JSONObject body = new JSONObject();
        body.put("queueId", type.getValue());

        final Request request = new Request.Builder()
                .url("https://api.anti-captcha.com/getQueueStats")
                .post(RequestBody.create(body.toString(), MediaType.parse("application/json")))
                .build();
        try (final Response response = client.newCall(request).execute()) {
            final String responseBody = response.body().string();
            final ObjectMapper mapper = new ObjectMapper();
            return (mapper.readValue(responseBody, QueueStatsResponse.class));
        }
    }

}
