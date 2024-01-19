package net.botlify.anticaptchacom.enums

/**
 * The type of the captcha to solve.
 */
enum class CaptchaType {
    /**
     * The Google reCAPTCHA v2 type.
     */
    RECAPTCHA_V2,


    @Deprecated("This type is not supported.")
    RECAPTCHA_V3,


    @Deprecated("This type is not supported.")
    IMAG_CAPTCHA,


    @Deprecated("This type is not supported.")
    RECAPTCHA_ENTERPRISE_V2_OR_V3,


    @Deprecated("This type is not supported.")
    HCAPTCHA,


    @Deprecated("This type is not supported.")
    GEETEST,


    @Deprecated("This type is not supported.")
    ARKOSE_LABS,


    @Deprecated("This type is not supported.")
    CUSTOM_TASKS,


    @Deprecated("This type is not supported.")
    TURNSTILE
}
