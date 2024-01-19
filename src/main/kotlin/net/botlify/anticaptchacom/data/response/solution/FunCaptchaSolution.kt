package net.botlify.anticaptchacom.data.response.solution

import com.fasterxml.jackson.annotation.JsonProperty

@Deprecated("Not implemented yet")
data class FunCaptchaSolution(
    @JsonProperty("solution")
    val solution: String,
)
