package net.botlify.anticaptchacom.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import net.botlify.anticaptchacom.enums.ProxyType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

@ToString
@EqualsAndHashCode(callSuper = true)
public class RecaptchaV2EnterpriseProxyRequest extends RecaptchaV2EnterpriseRequest {

    private final String type = "RecaptchaV2EnterpriseTask";


    /**
     * The proxy type to use for the worker.
     */
    @NotNull @Getter
    private final ProxyType proxyType;

    /**
     * The proxy address to use for the worker.
     */
    @NotNull @Getter
    private final String proxyAddress;

    /**
     * The proxy port to use for the worker.
     */
    @Getter
    private final int proxyPort;

    /**
     * The proxy login to use for the worker.
     */
    @Nullable
    @Getter
    private String proxyLogin;

    /**
     * The proxy password to use for the worker.
     */
    @Nullable @Getter
    private String proxyPassword;

    /**
     * The list of key and value of the cookies that we should use in Google domains.
     */
    @Nullable @Getter
    private Map<String, String> cookies;

    /**
     * The user agent to use for the worker.
     */
    @NotNull @Getter
    private final String userAgent;

    public RecaptchaV2EnterpriseProxyRequest(@NotNull final String websiteURL,
                                             @NotNull final String captchaSiteKey,
                                             @NotNull final String userAgent,
                                             @NotNull final ProxyType proxyType,
                                             @NotNull final String proxyAddress,
                                             final int proxyPort) {
        super(websiteURL, captchaSiteKey);
        this.userAgent = userAgent;
        this.proxyType = proxyType;
        this.proxyAddress = proxyAddress;
        this.proxyPort = proxyPort;
    }

    /**
     * Set the proxy login.
     * @param proxyLogin The proxy login.
     * @return The current instance.
     */
    public @NotNull RecaptchaV2EnterpriseProxyRequest setProxyLoginAndPassword(@NotNull final String proxyLogin,
                                                                               @NotNull final String proxyPassword) {
        this.proxyLogin = proxyLogin;
        this.proxyPassword = proxyPassword;
        return (this);
    }

    /**
     * Set the cookies to use for the worker.
     * @param cookies The cookies to use.
     * @return The current instance.
     */
    public @NotNull RecaptchaV2EnterpriseProxyRequest setCookies(@NotNull final Map<String, String> cookies) {
        this.cookies = cookies;
        return (this);
    }

}
