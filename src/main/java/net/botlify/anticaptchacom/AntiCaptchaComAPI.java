package net.botlify.anticaptchacom;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import net.botlify.anticaptchacom.api.AccountAPI;
import net.botlify.anticaptchacom.api.ReporterAPI;
import net.botlify.anticaptchacom.api.SolverAPI;
import net.botlify.anticaptchacom.enums.CaptchaServiceType;
import net.botlify.anticaptchacom.response.QueueStatsResponse;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.io.IOException;

/**
 * The {@link AntiCaptchaComAPI} is the main class to use to
 * solve captcha with anti-captcha.com.
 */
@Log4j2
@ToString
@EqualsAndHashCode
public final class AntiCaptchaComAPI {

  @NotNull
  @Getter
  private static final String apiUrl = "https://api.anti-captcha.com";

  @NotNull
  @Getter
  private final AntiCaptchaComConfig config;

  @NotNull
  @Getter
  private final HttpRequester httpRequester = new HttpRequester();

  /**
   * Construct a new {@link AntiCaptchaComAPI}.
   *
   * @param config The configuration.
   */
  public AntiCaptchaComAPI(@NotNull final AntiCaptchaComConfig config) {
    this.config = config;
  }

  /**
   * This method return the {@link ReporterAPI} to use
   * to notify the AntiCaptcha.com team about the captchas
   * that are not valid or valid.
   *
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

  // Static functions

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
