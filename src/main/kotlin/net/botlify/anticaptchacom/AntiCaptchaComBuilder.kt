package net.botlify.anticaptchacom

/**
 * The configuration of the AntiCaptchaCom API.
 */
class AntiCaptchaComBuilder(
    internal val apiKey: String
) {
    /**
     * The max number of attempts to solve a captcha.
     */
    internal var maxAttempts = 100

    internal var firstSleepBetweenAttemptsMillis = 3000

    internal var sleepBetweenAttemptsMillis = 1000

    /**
     * The id of the project.
     */
    internal var softId = 0

    fun setMaxAttempts(maxAttempts: Int): AntiCaptchaComBuilder {
        require(maxAttempts > 0) { "Max attempts must be greater than 0" }
        this.maxAttempts = maxAttempts
        return (this)
    }

    fun setSleepBetweenAttemptsMillis(sleepBetweenAttemptsMillis: Int): AntiCaptchaComBuilder {
        require(sleepBetweenAttemptsMillis > 0) { "Sleep between attempts must be greater than 0" }
        this.sleepBetweenAttemptsMillis = sleepBetweenAttemptsMillis
        return (this)
    }

    fun setFirstSleepBetweenAttemptsMillis(firstSleepBetweenAttemptsMillis: Int): AntiCaptchaComBuilder {
        require(firstSleepBetweenAttemptsMillis > 0) { "First sleep between attempts must be greater than 0" }
        this.firstSleepBetweenAttemptsMillis = firstSleepBetweenAttemptsMillis
        return (this)
    }

    /**
     * Sets the soft id.
     *
     * @param softId The soft id, must be greater than 0.
     * @return The current instance.
     */
    fun setSoftId(softId: Int): AntiCaptchaComBuilder {
        require(softId > 0) { "Soft id must be greater than 0" }
        this.softId = softId
        return (this)
    }

    fun build(): AntiCaptchaComClient {
        return AntiCaptchaComClient(this)
    }
}
