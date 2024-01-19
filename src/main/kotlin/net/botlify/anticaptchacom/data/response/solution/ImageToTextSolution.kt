package net.botlify.anticaptchacom.data.response.solution

import com.fasterxml.jackson.annotation.JsonProperty

@Deprecated("Not implemented yet")
data class ImageToTextSolution(
    /**
     * Text from image captcha.
     */
    @JsonProperty("text")
    private val text: String,

    /**
     * Web address where we'll store the captcha for the next 24 hours, after which it is removed.
     */
    @JsonProperty("url")
    private val url: String
)
