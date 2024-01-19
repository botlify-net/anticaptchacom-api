package net.botlify.anticaptchacom.data.response.solution

import com.fasterxml.jackson.annotation.JsonProperty

@Deprecated("Not implemented yet")
data class RecaptchaSolution(
    /**
     * Token string required for interacting with the submitted form on the target website.
     */
    @JsonProperty("gRecaptchaResponse")
    val gRecaptchaResponse: String,
)