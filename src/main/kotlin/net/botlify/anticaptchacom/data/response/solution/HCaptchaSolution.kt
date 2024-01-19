package net.botlify.anticaptchacom.data.response.solution

@Deprecated("Not implemented yet")
data class HCaptchaSolution(
    /**
     * Token string required for interacting with the submit form on the target website.
     */
    val gRecaptchaResponse: String,

    /**
     * Output of "window.hcaptcha.getRespKey()" function when it is available.
     * Some websites use it for additional verification.
     */
    val respKey: String,

    /**
     * User-Agent of worker's browser. Use it when you submit the response token.
     */
    val userAgent: String
)
