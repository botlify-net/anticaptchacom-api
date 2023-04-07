package net.botlify.anticaptchacom;

/**
 * The type of the captcha to solve.
 */
public enum CaptchaType {

    /**
     * The Google reCAPTCHA v2 type.
     */
    RECAPTCHA_V2,

    /**
     * @deprecated This type is not supported.
     */
    @Deprecated
    RECAPTCHA_V3,

    /**
     * @deprecated This type is not supported.
     */
    @Deprecated
    IMAG_CAPTCHA,

    /**
     * @deprecated This type is not supported.
     */
    @Deprecated
    RECAPTCHA_ENTERPRISE_V2_OR_V3,

    /**
     * @deprecated This type is not supported.
     */
    @Deprecated
    HCAPTCHA,

    /**
     * @deprecated This type is not supported.
     */
    @Deprecated
    GEETEST,

    /**
     * @deprecated This type is not supported.
     */
    @Deprecated
    ARKOSE_LABS,

    /**
     * @deprecated This type is not supported.
     */
    @Deprecated
    CUSTOM_TASKS,

    /**
     * @deprecated This type is not supported.
     */
    @Deprecated
    TURNSTILE;

}
