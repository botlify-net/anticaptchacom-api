package net.botlify.anticaptchacom.response.solution;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * The solution for the turnstile captcha.
 */
public class TurnstileSolution {

    /**
     * Token string required for interacting with the submit form on the target website.
     */
    @Getter(onMethod_ = @NotNull)
    private String token;

    /**
     * User-Agent of worker's browser. Use it when you submit the response token.
     */
    @Getter(onMethod_ = @NotNull)
    private String userAgent;

}
