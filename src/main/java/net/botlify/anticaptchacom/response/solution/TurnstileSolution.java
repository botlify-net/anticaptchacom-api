package net.botlify.anticaptchacom.response.solution;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jetbrains.annotations.NotNull;

/**
 * The solution for the turnstile captcha.
 */
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class TurnstileSolution {

  /**
   * Token string required for interacting with the submitted form on the target website.
   */
  @NotNull
  @JsonProperty("token")
  private final String token;

  /**
   * User-Agent of worker's browser. Use it when you submit the response token.
   */
  @NotNull
  @JsonProperty("userAgent")
  private final String userAgent;

}
