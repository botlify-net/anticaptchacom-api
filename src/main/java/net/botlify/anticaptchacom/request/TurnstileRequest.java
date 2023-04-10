package net.botlify.anticaptchacom.request;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * Turnstile captcha is another attempt to replace Recaptcha. We support all its subtypes
 * automatically: manual, non-interactive and invisible. No need to specify the subtype.
 * Also providing your own custom User-Agent is not necessary and won't work at all.
 */
public class TurnstileRequest implements SolveRequest {

    @NotNull @Getter
    private final String type = "TurnstileTaskProxyless";

    /**
     * Address of a target web page. Can be located anywhere on the web site, even in a member area.
     * Our workers don't navigate there but simulate the visit instead.
     */
    @NotNull @Getter
    private final String websiteURL;

    /**
     * Turnstile sitekey.
     */
    @NotNull @Getter
    private final String websiteKey;

    public TurnstileRequest(@NotNull final String websiteURL,
                            @NotNull final String websiteKey) {
        this.websiteURL = websiteURL;
        this.websiteKey = websiteKey;
    }

}
