package net.botlify.anticaptchacom.response.solution;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class ImageToTextSolution {

    /**
     * Text from image captcha.
     */
    @Getter @JsonProperty("text")
    private String text;

    /**
     * Web address where we'll store the captcha for the next 24 hours, after which it will be removed.
     */
    @Getter @JsonProperty("url")
    private String url;

}
