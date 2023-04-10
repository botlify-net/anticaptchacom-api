package net.botlify.anticaptchacom.response.solution;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class RecaptchaSolution {

    /**
     * Token string required for interacting with the submit form on the target website.
     */
    @Getter @JsonProperty("gRecaptchaResponse")
    private String gRecaptchaResponse;

}
