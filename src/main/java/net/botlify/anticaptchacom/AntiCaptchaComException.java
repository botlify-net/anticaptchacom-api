package net.botlify.anticaptchacom;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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

    /**
     * Verifies that the request was successful.
     * @param code The code of the response.
     * @param body The body of the response.
     * @throws AntiCaptchaComException If the request was not successful.
     */
    static void verifyRequest(final int code,
                                @NotNull final String body) throws AntiCaptchaComException {
        // If code is between 0 and 399, the request was successful.
        if (code >= 0 && code <= 399)
            return;
        throw (new AntiCaptchaComException(code, body));
    }

}
