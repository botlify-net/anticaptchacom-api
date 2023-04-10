package net.botlify.anticaptchacom.enums;

import lombok.Getter;

/**
 * This enum list all the GeeTest versions supported by the API.
 */
public enum GeeTestVersion {

    /**
     * The version 3 of the GeeTest.
     */
    VERSION_3(3),

    /**
     * The version 4 of the GeeTest.
     */
    VERSION_4(4);

    /**
     * The version of the GeeTest.
     */
    @Getter
    private final int version;

    /**
     * Creates a new {@link GeeTestVersion}.
     * @param version The version of the GeeTest.
     */
    GeeTestVersion(final int version) {
        this.version = version;
    }

}
