package net.botlify.anticaptchacom.request;

import lombok.Getter;
import net.botlify.anticaptchacom.enums.ProxyType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * This type of task solves arkoselabs.com puzzles in our workers' browsers. Your app submits
 * the website address and public key and receives a token after task completion. Use this token to
 * submit the form with the Arkose Labs captcha.
 * @see <a href="https://anti-captcha.com/apidoc/task-types/FunCaptchaTask">Documentation</a>
 */
public class FunCaptchaProxyRequest extends FunCaptchaRequest {

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
     * The user agent to use for the worker.
     */
    @NotNull @Getter
    private final String userAgent;

    /**
     * Construct a new request.
     * @param websiteURL Address of a target web page.
     * @param websitePublicKey Arkose Labs public key.
     */
    public FunCaptchaProxyRequest(@NotNull final String websiteURL,
                                  @NotNull final String websitePublicKey,
                                  @NotNull final String userAgent,
                                  @NotNull final ProxyType proxyType,
                                  @NotNull final String proxyAddress,
                                  final int proxyPort) {
        super(websiteURL, websitePublicKey);
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
    public @NotNull FunCaptchaProxyRequest setProxyLoginAndPassword(@NotNull final String proxyLogin,
                                                                    @NotNull final String proxyPassword) {
        this.proxyLogin = proxyLogin;
        this.proxyPassword = proxyPassword;
        return (this);
    }

}
