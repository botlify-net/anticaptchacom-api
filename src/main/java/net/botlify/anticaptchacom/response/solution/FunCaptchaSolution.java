package net.botlify.anticaptchacom.response.solution;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public class FunCaptchaSolution {

    @Getter(onMethod_ = @NotNull)
    private String solution;

}
