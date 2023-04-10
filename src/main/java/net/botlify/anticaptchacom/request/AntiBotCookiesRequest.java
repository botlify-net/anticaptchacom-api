package net.botlify.anticaptchacom.request;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

/**
 * This type of task where our worker navigates to a web page at your choice, bypasses any
 * anti-bot screen, grabs cookies and returns them to your app. You can then use these cookies
 * to freely navigate at this website with your favorite programming language. To successfully
 * bypass this kind of bot-catching pages, you'll also need User-Agent value of our worker's browser
 * and provide us a proxy of a good quality. Without proxies this method won't work, as all of
 * anti-bot solutions match their cookies with IP address of the visitor and their User-Agent.
 */
public class AntiBotCookiesRequest implements SolveRequest {

    @NotNull @Getter
    private final String type = "AntiBotCookieTask";

    /**
     * Address of a target web page where our worker will navigate.
     */
    @NotNull @Getter
    private final String websiteURL;

    /**
     * Proxy IP address ipv4/ipv6. No host names or IP addresses from local networks.
     */
    @NotNull @Getter
    private final String proxyAddress;

    /**
     * Proxy port.
     */
    @Getter
    private final int proxyPort;

    /**
     * Login for proxy which requires authorization (basic).
     */
    @NotNull @Getter
    private final String proxyLogin;

    /**
     * Proxy password.
     */
    @NotNull @Getter
    private final String proxyPassword;

    /**
     * Construct a new request.
     * @param websiteURL Address of a target web page.
     * @param proxyAddress Proxy IP address ipv4/ipv6. No host names or IP addresses from local networks.
     * @param proxyPort Proxy port.
     * @param proxyLogin Login for proxy which requires authorization (basic).
     * @param proxyPassword The proxy password.
     */
    public AntiBotCookiesRequest(@NotNull final String websiteURL,
                                 @NotNull final String proxyAddress,
                                 @Range(from = 0, to = 65535) final int proxyPort,
                                 @NotNull final String proxyLogin,
                                 @NotNull final String proxyPassword) {
        this.websiteURL = websiteURL;
        this.proxyAddress = proxyAddress;
        this.proxyPort = proxyPort;
        this.proxyLogin = proxyLogin;
        this.proxyPassword = proxyPassword;
    }

}
