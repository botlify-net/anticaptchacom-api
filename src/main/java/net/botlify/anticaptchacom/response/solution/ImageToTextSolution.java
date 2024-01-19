package net.botlify.anticaptchacom.response.solution;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class ImageToTextSolution {

  /**
   * Text from image captcha.
   */
  @JsonProperty("text")
  private String text;

  /**
   * Web address where we'll store the captcha for the next 24 hours, after which it is removed.
   */
  @JsonProperty("url")
  private String url;

}
