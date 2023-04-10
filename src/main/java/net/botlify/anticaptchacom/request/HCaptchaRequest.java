package net.botlify.anticaptchacom.request;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class HCaptchaRequest implements SolveRequest {

    @NotNull @Getter
    private final String type = "HCaptchaTaskProxyless";

    /**
     * Address of a target web page. Can be located anywhere on the web site, even in a member area. Our workers don't
     * navigate there but simulate the visit instead.
     */
    @NotNull @Getter
    private final String websiteURL;

    /**
     * hCaptcha sitekey.
     */
    @NotNull @Getter
    private final String websiteKey;

    /**
     * Provide the User Agent you are using to navigate the website. Our workers will use
     * same value during Hcaptcha solving process.
     * @deprecated Instead, use User-Agent from in the solution instead.
     */
    @Deprecated @Nullable @Getter
    private String userAgent;

    /**
     * Specify whether Hcaptcha is invisible.
     * This will render an appropriate widget for our workers.
     */
    @Nullable @Getter
    private Boolean isInvisible;

    /**
     * Additional parameters which we'll use to rfeature3,ender Hcaptcha widget for Enterprise version.
     */
    @Nullable @Getter
    private Map<String, String> enterprisePayload;

    /**
     * Construct a new request for hCaptcha.
     * @param websiteURL Address of a target web page.
     * @param websiteKey hCaptcha sitekey.
     */
    public HCaptchaRequest(@NotNull final String websiteURL,
                           @NotNull final String websiteKey) {
        this.websiteURL = websiteURL;
        this.websiteKey = websiteKey;
    }

    /**
     * Provide the User Agent you are using to navigate the website. Our workers will use
     * same value during Hcaptcha solving process.
     * @param userAgent The user agent to use when solving the captcha.
     * @return This request.
     * @deprecated Instead, use User-Agent from in the solution instead.
     */
    @Deprecated
    public @NotNull HCaptchaRequest setUserAgent(@Nullable final String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    /**
     * Additional parameters which we'll use to render Hcaptcha widget for Enterprise version.
     * @param enterprisePayload Additional parameters.
     * @return This request.
     */
    public @NotNull HCaptchaRequest setEnterprisePayload(@Nullable final Map<String, String> enterprisePayload) {
        this.enterprisePayload = enterprisePayload;
        return this;
    }

    /**
     * Specify whether Hcaptcha is invisible.
     * @param isInvisible Whether Hcaptcha is invisible.
     * @return This request.
     */
    public @NotNull HCaptchaRequest setIsInvisible(@Nullable final Boolean isInvisible) {
        this.isInvisible = isInvisible;
        return this;
    }

}
