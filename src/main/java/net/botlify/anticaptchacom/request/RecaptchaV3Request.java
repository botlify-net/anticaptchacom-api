package net.botlify.anticaptchacom.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import net.botlify.anticaptchacom.enums.RecaptchaV3MinScore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ToString
@EqualsAndHashCode
public class RecaptchaV3Request implements SolveRequest {

    /**
     * The type of the task.
     */
    private final String type = "RecaptchaV3Task";

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
     * The minimum score to accept the solution.
     */
    @NotNull @Getter
    private final RecaptchaV3MinScore minScore;

    /**
     * Recaptcha's "action" value. Website owners use this parameter to define what
     * users are doing on the page.<br />
     * <u>Example:</u> grecaptcha.execute('site_key', {action:'login_test'})
     */
    @Nullable @Getter
    private String pageAction;

    /**
     * Set this flag to "true" if you need this V3 solved with Enterprise API. Default value is "false" and Recaptcha
     * is solved with non-enterprise API. Can be determined by a javascript call like in the following example:<br />
     * grecaptcha.enterprise.execute('site_key', {..})
     */
    @Nullable @Getter
    private Boolean isEnterprise;

    /**
     * Use this parameter to send the domain name from which the Recaptcha script should be served. Can have only one
     * of two values: "www.google.com" or "www.recaptcha.net". Do not use this parameter unless you understand
     * what you are doing.
     */
    @Nullable @Getter
    private String apiDomain;

    /**
     * Construct a new {@link RecaptchaV2Request}.
     * @param websiteURL The website URL.
     * @param captchaSiteKey The captcha site key.
     * @param minScore The minimum score to accept the solution.
     */
    public RecaptchaV3Request(@NotNull final String websiteURL,
                              @NotNull final String captchaSiteKey,
                              @NotNull final RecaptchaV3MinScore minScore) {
        this.websiteURL = websiteURL;
        this.captchaSiteKey = captchaSiteKey;
        this.minScore = minScore;
    }

    public @NotNull RecaptchaV3Request setPageAction(@NotNull final String pageAction) {
        this.pageAction = pageAction;
        return (this);
    }

    public @NotNull RecaptchaV3Request setIsEnterprise(final boolean isEnterprise) {
        this.isEnterprise = isEnterprise;
        return (this);
    }

    public @NotNull RecaptchaV3Request setApiDomain(@NotNull final String apiDomain) {
        this.apiDomain = apiDomain;
        return (this);
    }

}
