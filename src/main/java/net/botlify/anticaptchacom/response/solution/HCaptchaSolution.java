package net.botlify.anticaptchacom.response.solution;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

@ToString
@EqualsAndHashCode
public class HCaptchaSolution {

  /**
   * Token string required for interacting with the submit form on the target website.
   */
  @NotNull
  @Getter
  private String gRecaptchaResponse;

  /**
   * Output of "window.hcaptcha.getRespKey()" function when it is available.
   * Some websites use it for additional verification.
   */
  @NotNull
  @Getter
  private String respKey;

  /**
   * User-Agent of worker's browser. Use it when you submit the response token.
   */
  @NotNull
  @Getter
  private String userAgent;

}
