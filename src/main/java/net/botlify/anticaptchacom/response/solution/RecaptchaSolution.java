package net.botlify.anticaptchacom.response.solution;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class RecaptchaSolution {

  /**
   * Token string required for interacting with the submitted form on the target website.
   */
  @JsonProperty("gRecaptchaResponse")
  private String gRecaptchaResponse;

}
