package net.botlify.anticaptchacom.exceptions;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * An exception thrown by the AntiCaptchaCom API.
 */
public final class AntiCaptchaComException extends Exception {

    /**
     * The code of the response.
     */
    @Getter
    private final int code;

    /**
     * The body of the response.
     */
    @Getter @NotNull
    private final String body;

    public AntiCaptchaComException(final int code,
                                   @NotNull final String body) {
        super("AntiCaptchaCom API error: " + code + " - " + body);
        this.code = code;
        this.body = body;
    }

}
