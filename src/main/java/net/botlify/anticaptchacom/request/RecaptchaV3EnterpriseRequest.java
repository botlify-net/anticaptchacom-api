package net.botlify.anticaptchacom.request;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class RecaptchaV3EnterpriseRequest implements SolveRequest {

    /**
     * The task type.
     */
    @Getter
    private final String type = "RecaptchaV2EnterpriseTaskProxyless";

    /**
     * Address of a target web page. Can be located anywhere on the website, even in a member area.
     * Our workers don't navigate there but simulate the visit instead.
     */
    @NotNull @Getter
    private final String websiteURL;

    /**
     * Recaptcha website key. Learn how to find it in this article
     * <a href="https://anti-captcha.com/fr/apidoc/articles/how-to-find-the-sitekey">here</a>.
     */
    @NotNull @Getter
    private final String captchaSiteKey;

    @Nullable @Getter
    private String apiDomain;

    @Nullable @Getter
    private Map<String, String> enterprisePayload;

    public RecaptchaV3EnterpriseRequest(@NotNull final String websiteURL,
                                        @NotNull final String captchaSiteKey) {
        this.websiteURL = websiteURL;
        this.captchaSiteKey = captchaSiteKey;
    }

    public @NotNull RecaptchaV3EnterpriseRequest setApiDomain(@NotNull final String apiDomain) {
        this.apiDomain = apiDomain;
        return (this);
    }

    public @NotNull RecaptchaV3EnterpriseRequest setEnterprisePayload(@NotNull final Map<String, String> enterprisePayload) {
        this.enterprisePayload = enterprisePayload;
        return (this);
    }

}
