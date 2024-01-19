package net.botlify.anticaptchacom;

import net.botlify.anticaptchacom.exceptions.AntiCaptchaComException;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.io.IOException;

class HttpRequester {

  @NotNull
  private final OkHttpClient client;

  public HttpRequester() {
    this.client = new OkHttpClient.Builder()
        .build();
  }

  public @NotNull String sendPost(@NotNull final String url,
                                  @NotNull final JSONObject body) throws IOException, AntiCaptchaComException {
    return (HttpRequester.sendPost(client, url, body.toString()));
  }

  public @NotNull String sendPost(@NotNull final String url,
                                  @NotNull final Object body) throws IOException, AntiCaptchaComException {
    return (HttpRequester.sendPost(client, url, body));
  }

  /**
   * This method sends a POST request to the url given in parameter.
   *
   * @param url  The url.
   * @param body The body as a JSON object.
   * @return The response.
   */
  public static @NotNull String sendPost(@NotNull final OkHttpClient client,
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
   * This method sends a GET request to the url given in parameter.
   *
   * @param client The HTTP client.
   * @param url    The url.
   * @return The response as String format.
   * @throws AntiCaptchaComException If the request failed.
   * @throws IOException             If the request failed.
   */
  public static @NotNull String sendGet(@NotNull final OkHttpClient client,
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
   *
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

}
