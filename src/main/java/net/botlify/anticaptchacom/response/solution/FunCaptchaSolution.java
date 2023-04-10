package net.botlify.anticaptchacom.response.solution;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

@ToString
@EqualsAndHashCode
public class FunCaptchaSolution {

    @Getter(onMethod_ = @NotNull)
    private String solution;

}
