package net.botlify.anticaptchacom;

import org.jetbrains.annotations.NotNull;

/**
 * This class is used to report incorrect captchas.
 */
public final class ReporterAPI {

    @NotNull
    private final AntiCaptchaComAPI api;

    ReporterAPI(@NotNull final AntiCaptchaComAPI api) {
        this.api = api;
    }

    @Deprecated
    public void reportIncorrectImageCaptcha(@NotNull final String taskId) {

    }

    @Deprecated
    public void reportIncorrectRecaptcha(@NotNull final String taskId) {

    }

    @Deprecated
    public void reportCorrectRecaptcha(@NotNull final String taskId) {

    }

    @Deprecated
    public void reportIncorrectHCaptcha(@NotNull final String taskId) {

    }

}
