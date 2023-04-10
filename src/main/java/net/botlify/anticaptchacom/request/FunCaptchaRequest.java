package net.botlify.anticaptchacom.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This type of task solves Arkose Labs captcha (or Funcaptcha) without proxy. Task will be executed using our own
 * proxy servers and/or workers' IP addresses.<br />
 * Arkose Labs API provides information to the website owner about the solver's IP address. However, it's worth trying
 * first to bypass captcha without proxy, and if it doesn't work, switch to FuncaptchaTask with proxy.
 */
public class FunCaptchaRequest implements SolveRequest {

    @NotNull @Getter
    private final String type = "FunCaptchaTaskProxyless";

    /**
     * Address of a target web page. Can be located anywhere on the website, even in a member area.
     * Our workers don't navigate there but simulate the visit instead.
     */
    @NotNull @Getter
    private final String websiteURL;

    /**
     * Arkose Labs public key.
     */
    @NotNull @Getter
    private final String websitePublicKey;

    /**
     * Custom Arkose Labs subdomain from which the Javascript widget is loaded. Required for some cases,
     * but most Arkose Labs integrations run without it.
     */
    @Nullable @Getter @JsonProperty("funcaptchaApiJSSubdomain")
    private String funCaptchaApiJSSubDomain;

    /**
     * An additional parameter that may be required by Arkose Labs implementation. Use this property to send "blob"
     * value as an object converted to a string.<br />
     * See an example of what it might look like:
     * {"blob":"HERE_COMES_THE_blob_VALUE"}
     */
    @Nullable @Getter
    private String data;

    /**
     * Construct a new request.
     * @param websiteURL Address of a target web page.
     * @param websitePublicKey Arkose Labs public key.
     */
    public FunCaptchaRequest(@NotNull final String websiteURL,
                             @NotNull final String websitePublicKey) {
        this.websiteURL = websiteURL;
        this.websitePublicKey = websitePublicKey;
    }

    /**
     * Custom Arkose Labs subdomain from which the Javascript widget is loaded. Required for some cases,
     * but most Arkose Labs integrations run without it.
     * @param funCaptchaApiJSSubDomain Custom Arkose Labs subdomain from which the Javascript widget is loaded.
     * @return This object.
     */
    public @NotNull FunCaptchaRequest setFunCaptchaApiJSSubDomain(@Nullable final String funCaptchaApiJSSubDomain) {
        this.funCaptchaApiJSSubDomain = funCaptchaApiJSSubDomain;
        return this;
    }

    /**
     * An additional parameter that may be required by Arkose Labs implementation. Use this property to send "blob"
     * value as an object converted to a string.<br />
     * See an example of what it might look like:
     * {"blob":"HERE_COMES_THE_blob_VALUE"}
     * @param data The "blob" value as an object converted to a string.
     * @return This object.
     */
    public @NotNull FunCaptchaRequest setData(@Nullable final String data) {
        this.data = data;
        return this;
    }

}
