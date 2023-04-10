package net.botlify.anticaptchacom.request;

import lombok.Getter;
import net.botlify.anticaptchacom.enums.GeeTestVersion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * This type of task solves GeeTest captchas in our workers' browsers. Your app submits the
 * website address, gt key, challenge key and after task completion receives a solution
 * consisting of 3 tokens. For version GeeTest version 4 output consists of 5 values and
 * challenge key is not required.
 */
public class GeeTestRequest implements SolveRequest {

    private final String type = "GeeTestTaskProxyless";

    /**
     * Address of a target web page. Can be located anywhere on the web site, even in a member area. Our workers don't
     * navigate there but simulate the visit instead.
     */
    @NotNull @Getter
    private final String websiteURL;

    /**
     * The domain public key, rarely updated.
     */
    @Getter
    private final String gt;

    /**
     * Changing token key. Make sure you grab a fresh one for each captcha; otherwise, you'll be charged for an error
     * task. Required for version 3. Not required for version 4.
     */
    @Nullable @Getter
    private String challenge;

    /**
     * Optional API subdomain. May be required for some implementations.
     */
    @Nullable @Getter
    private String geetestApiServerSubdomain;

    /**
     * Required for some implementations. Send the JSON encoded into a string. The value can be traced in browser
     * developer tools. Put a breakpoint before calling the "initGeetest" function.
     */
    @Nullable @Getter
    private String geetestGetLib;

    /**
     * Version number. Default version is 3. Supported versions: 3 and 4.
     */
    @NotNull @Getter
    private GeeTestVersion version = GeeTestVersion.VERSION_3;

    /**
     * Additional initialization parameters for version 4.
     */
    @Nullable @Getter
    private Map<String, String> initParameters = null;

    /**
     * Construct a new request.
     * @param websiteURL Address of a target web page.
     * @param gt The domain public key.
     */
    public GeeTestRequest(@NotNull final String websiteURL,
                          @NotNull final String gt) {
        this.websiteURL = websiteURL;
        this.gt = gt;
    }

    public @NotNull GeeTestRequest setChallenge(@NotNull final String challenge) {
        this.challenge = challenge;
        return this;
    }

    public @NotNull GeeTestRequest setGeeTestApiServerSubdomain(@NotNull final String geetestApiServerSubdomain) {
        this.geetestApiServerSubdomain = geetestApiServerSubdomain;
        return this;
    }

    public @NotNull GeeTestRequest setGeeTestGetLib(@NotNull final String geetestGetLib) {
        this.geetestGetLib = geetestGetLib;
        return this;
    }

    public @NotNull GeeTestRequest setVersion(@NotNull final GeeTestVersion version) {
        this.version = version;
        return this;
    }

    public @NotNull GeeTestRequest setInitParameters(@NotNull final Map<String, String> initParameters) {
        this.initParameters = initParameters;
        return this;
    }

}
