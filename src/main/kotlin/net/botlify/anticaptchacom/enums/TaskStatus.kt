package net.botlify.anticaptchacom.enums

enum class TaskStatus(val value: String) {
    PROCESSING("processing"),
    READY("ready");

    companion object {
        fun fromValue(value: String): TaskStatus? {
            return when (value) {
                "processing" -> PROCESSING
                "ready" -> READY
                else -> null
            }
        }
    }

}
