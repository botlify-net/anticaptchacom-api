package net.botlify.anticaptchacom.data.response.solution

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * The solution for the turnstile captcha.
 */
class TurnstileSolution internal constructor(
    /**
     * Token string required for interacting with the submitted form on the target website.
     */
    @JsonProperty("token")
    val token: String,

    /**
     * User-Agent of worker's browser. Use it when you submit the response token.
     */
    @JsonProperty("userAgent")
    val userAgent: String
)
