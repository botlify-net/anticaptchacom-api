package net.botlify.anticaptchacom.request;

import lombok.Getter;
import net.botlify.anticaptchacom.enums.ProxyType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This type of task solves GeeTest captchas in our workers' browsers. Your app submits
 * the website address, gt key, challenge key and after task completion receives a
 * solution consisting of 3 tokens. For version GeeTest version 4 output consists of 5
 * values and challenge key is not required.
 */
public class GeeTestProxyRequest extends GeeTestRequest {

    /**
     * The task type.
     */
    @Getter
    private final String type = "GeeTestTask";

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
     * @param gt The domain public key.
     */
    public GeeTestProxyRequest(@NotNull final String websiteURL,
                               @NotNull final String gt,
                               @NotNull final String userAgent,
                               @NotNull final ProxyType proxyType,
                               @NotNull final String proxyAddress,
                               final int proxyPort) {
        super(websiteURL, gt);
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
    public @NotNull GeeTestProxyRequest setProxyLoginAndPassword(@NotNull final String proxyLogin,
                                                                 @NotNull final String proxyPassword) {
        this.proxyLogin = proxyLogin;
        this.proxyPassword = proxyPassword;
        return (this);
    }

}
