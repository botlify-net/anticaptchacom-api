package net.botlify.anticaptchacom.enums

enum class RecaptchaV3MinScore(val value: Double) {
    /**
     * The minimum score for the captcha to be solved.
     * The value is 0.3.
     */
    SCORE_0_3(0.3),

    /**
     * The minimum score for the captcha to be solved.
     * The value is 0.7.
     */
    SCORE_0_7(0.7),

    /**
     * The minimum score for the captcha to be solved.
     * The value is 0.9.
     */
    SCORE_0_9(0.9)
}
