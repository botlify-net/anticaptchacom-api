package net.botlify.anticaptchacom;

import lombok.AccessLevel;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

/**
 * The configuration of the AntiCaptchaCom API.
 */
public final class AntiCaptchaComConfig {

  /**
   * The api key of anti-captcha.com.
   */
  @NotNull
  @Getter
  private final String apiKey;

  /**
   * The max number of attempts to solve a captcha.
   */
  @Getter
  private int maxAttempts = 100;

  @Getter
  private int sleepBetweenAttemptsMillis = 1000;

  /**
   * The id of the project.
   */
  @Getter(AccessLevel.PACKAGE)
  private int softId = 0;

  /**
   * Creates a new {@link AntiCaptchaComConfig}.
   *
   * @param apiKey The API key.
   */
  public AntiCaptchaComConfig(@NotNull final String apiKey) {
    this.apiKey = apiKey;
  }

  public @NotNull AntiCaptchaComConfig setMaxAttempts(final int maxAttempts) {
    if (maxAttempts <= 0)
      throw new IllegalArgumentException("Max attempts must be greater than 0");
    this.maxAttempts = maxAttempts;
    return (this);
  }

  public @NotNull AntiCaptchaComConfig setSleepBetweenAttemptsMillis(final int sleepBetweenAttemptsMillis) {
    if (sleepBetweenAttemptsMillis <= 0)
      throw new IllegalArgumentException("Sleep between attempts must be greater than 0");
    this.sleepBetweenAttemptsMillis = sleepBetweenAttemptsMillis;
    return (this);
  }

  /**
   * Sets the soft id.
   *
   * @param softId The soft id, must be greater than 0.
   * @return The current instance.
   */
  public @NotNull AntiCaptchaComConfig setSoftId(@Range(from = 0, to = Integer.MAX_VALUE) final int softId) {
    this.softId = softId;
    return (this);
  }

}
