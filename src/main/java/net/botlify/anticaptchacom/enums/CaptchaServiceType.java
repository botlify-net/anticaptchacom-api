package net.botlify.anticaptchacom.enums;

/**
 * An enum that represents various types of captcha services.
 */
public enum CaptchaServiceType {
    IMAGE_TO_TEXT_ENGLISH(1),
    IMAGE_TO_TEXT_RUSSIAN(2),
    RECAPTCHA_V2_WITH_PROXY(5),
    RECAPTCHA_V2_WITHOUT_PROXY(6),
    FUNCAPTCHA_WITH_PROXY(7),
    FUNCAPTCHA_WITHOUT_PROXY(10),
    GEETEST_WITH_PROXY(12),
    GEETEST_WITHOUT_PROXY(13),
    RECAPTCHA_V3_S0_3(18),
    RECAPTCHA_V3_S0_7(19),
    RECAPTCHA_V3_S0_9(20),
    HCAPTCHA_WITH_PROXY(21),
    HCAPTCHA_WITHOUT_PROXY(22),
    RECAPTCHA_ENTERPRISE_V2_WITH_PROXY(23),
    RECAPTCHA_ENTERPRISE_V2_WITHOUT_PROXY(24),
    ANTIGATETASK(25),
    TURNSTILE_WITH_PROXY(26),
    TURNSTILE_WITHOUT_PROXY(27);

    private final int value;

    /**
     * Constructor that initializes the enum value.
     *
     * @param value the integer value of the enum.
     */
    private CaptchaServiceType(int value) {
        this.value = value;
    }

    /**
     * Returns the integer value of the enum.
     *
     * @return the integer value of the enum.
     */
    public int getValue() {
        return value;
    }
}

