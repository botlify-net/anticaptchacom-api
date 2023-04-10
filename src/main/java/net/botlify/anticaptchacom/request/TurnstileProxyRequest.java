package net.botlify.anticaptchacom.request;

import lombok.Getter;
import net.botlify.anticaptchacom.enums.ProxyType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Turnstile captcha is another attempt to replace Recaptcha. We support all its subtypes
 * automatically: manual, non-interactive and invisible. No need to specify the subtype.
 * Also providing your own custom User-Agent is not necessary and won't work at all.
 */
public class TurnstileProxyRequest extends TurnstileRequest {

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

    public TurnstileProxyRequest(@NotNull final String websiteURL,
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
    public @NotNull TurnstileProxyRequest setProxyLoginAndPassword(@NotNull final String proxyLogin,
                                                                   @NotNull final String proxyPassword) {
        this.proxyLogin = proxyLogin;
        this.proxyPassword = proxyPassword;
        return (this);
    }

}
