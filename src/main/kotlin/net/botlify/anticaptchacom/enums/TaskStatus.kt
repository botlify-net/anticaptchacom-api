package net.botlify.anticaptchacom.enums

import com.fasterxml.jackson.annotation.JsonValue

enum class TaskStatus(@get:JsonValue val value: String) {
    PROCESSING("processing"),
    READY("ready");
}
