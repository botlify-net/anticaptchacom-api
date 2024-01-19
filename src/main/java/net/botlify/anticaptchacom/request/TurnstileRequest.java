package net.botlify.anticaptchacom.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

/**
 * Turnstile captcha is another attempt to replace Recaptcha. We support all its subtypes
 * automatically: manual, non-interactive and invisible. No need to specify the subtype.
 * Also providing your own custom User-Agent is not necessary and won't work at all.
 */
@Getter
@ToString
@EqualsAndHashCode
public class TurnstileRequest implements SolveRequest {

  @NotNull
  private final String type = "TurnstileTaskProxyless";

  /**
   * Address of a target web page. Can be located anywhere on the web site, even in a member area.
   * Our workers don't navigate there but simulate the visit instead.
   */
  @NotNull
  @JsonProperty("websiteURL")
  private final String websiteURL;

  /**
   * Turnstile sitekey.
   */
  @NotNull
  @JsonProperty("websiteKey")
  private final String websiteKey;

  public TurnstileRequest(@NotNull final String websiteURL,
                          @NotNull final String websiteKey) {
    this.websiteURL = websiteURL;
    this.websiteKey = websiteKey;
  }

}
