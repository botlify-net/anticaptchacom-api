package net.botlify.anticaptchacom.request;

import lombok.Getter;
import net.botlify.anticaptchacom.enums.RecaptchaV3MinScore;
import org.jetbrains.annotations.NotNull;

public class RecaptchaV3EnterpriseRequest extends RecaptchaV3Request {

    @NotNull @Getter
    private final String type = "RecaptchaV3TaskProxyless";

    @Getter
    private final boolean isEnterprise = true;

    /**
     * Construct a new {@link RecaptchaV2Request}.
     *
     * @param websiteURL     The website URL.
     * @param captchaSiteKey The captcha site key.
     * @param minScore       The minimum score to accept the solution.
     */
    public RecaptchaV3EnterpriseRequest(@NotNull String websiteURL, @NotNull String captchaSiteKey, @NotNull RecaptchaV3MinScore minScore) {
        super(websiteURL, captchaSiteKey, minScore);
    }
}
