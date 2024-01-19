package net.botlify.anticaptchacom.data.request

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Turnstile captcha is another attempt to replace Recaptcha. We support all its subtypes
 * automatically: manual, non-interactive, and invisible. No need to specify the subtype.
 * Also providing your own custom User-Agent is not necessary and won't work at all.
 */
data class TurnstileRequest(
    /**
     * Address of a target web page. Can be located anywhere on the website, even in a member area.
     * Our workers don't navigate there but simulate the visit instead.
     */
    @JsonProperty("websiteURL")
    val websiteURL: String,

    /**
     * Turnstile site key.
     */
    @JsonProperty("websiteKey")
    val websiteKey: String,

    @JsonProperty("action")
    val action: String? = null,

    @JsonProperty("turnstileCData")
    val turnstileCData: String? = null,
) {
    @JsonProperty("type")
    val type = "TurnstileTaskProxyless"
}
