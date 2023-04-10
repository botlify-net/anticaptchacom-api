package net.botlify.anticaptchacom.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Define a task to solve a Recaptcha V2 without proxy.
 * @see <a href="https://anti-captcha.com/apidoc/task-types/RecaptchaV2TaskProxyless">RecaptchaV2TaskProxyless</a>
 */
@ToString
@EqualsAndHashCode
public class RecaptchaV2Request implements SolveRequest {

    /**
     * The task type.
     */
    @Getter
    private final String type = "RecaptchaV2TaskProxyless";

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

    /**
     * Value of 'data-s' parameter. Applies only to Recaptchas on Google web sites.
     */
    @Nullable @Getter
    private String recaptchaDataSValue;

    /**
     * Specify whether Recaptcha is invisible. This will
     * render an appropriate widget for our workers.
     */
    @Nullable @Getter
    private Boolean isInvisible = null;

    /**
     * Construct a new {@link RecaptchaV2Request}.
     * @param websiteURL The website URL.
     * @param captchaSiteKey The captcha site key.
     */
    public RecaptchaV2Request(@NotNull final String websiteURL,
                              @NotNull final String captchaSiteKey) {
        this.websiteURL = websiteURL;
        this.captchaSiteKey = captchaSiteKey;
    }

    public @NotNull RecaptchaV2Request setRecaptchaDataSValue(@NotNull final String recaptchaDataSValue) {
        this.recaptchaDataSValue = recaptchaDataSValue;
        return (this);
    }

    public @NotNull RecaptchaV2Request setIsInvisible(final boolean isInvisible) {
        this.isInvisible = isInvisible;
        return (this);
    }

}
