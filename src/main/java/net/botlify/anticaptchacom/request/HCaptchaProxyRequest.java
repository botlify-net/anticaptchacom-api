package net.botlify.anticaptchacom.request;

import lombok.Getter;
import net.botlify.anticaptchacom.enums.ProxyType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HCaptchaProxyRequest extends HCaptchaRequest {

    @NotNull @Getter
    private final String type = "HCaptchaTask";

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
     * Construct a new request for hCaptcha.
     * @param websiteURL Address of a target web page.
     * @param websiteKey hCaptcha sitekey.
     */
    public HCaptchaProxyRequest(@NotNull final String websiteURL,
                                @NotNull final String websiteKey,
                                @NotNull final ProxyType proxyType,
                                @NotNull final String proxyAddress,
                                final int proxyPort) {
        super(websiteURL, websiteKey);
        this.proxyType = proxyType;
        this.proxyAddress = proxyAddress;
        this.proxyPort = proxyPort;
    }

    /**
     * Set the proxy login.
     * @param proxyLogin The proxy login.
     * @return The current instance.
     */
    public @NotNull HCaptchaProxyRequest setProxyLoginAndPassword(@NotNull final String proxyLogin,
                                                                  @NotNull final String proxyPassword) {
        this.proxyLogin = proxyLogin;
        this.proxyPassword = proxyPassword;
        return (this);
    }

}
