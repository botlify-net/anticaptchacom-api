package net.botlify.anticaptchacom.exceptions

import com.fasterxml.jackson.annotation.JsonProperty
import net.botlify.anticaptchacom.enums.AntiCaptchaComError

/**
 * An exception thrown by the AntiCaptchaCom API.
 */
data class AntiCaptchaComException internal constructor(
    @JsonProperty("errorId")
    val errorId: Int,
    @JsonProperty("errorCode")
    val errorCode: AntiCaptchaComError,
    @JsonProperty("errorDescription")
    val errorDescription: String
) : Exception(errorDescription)
