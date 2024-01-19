package net.botlify.anticaptchacom.data.request

/**
 * This type of task where our worker navigates to a web page at your choice, bypasses any
 * anti-bot screen, grabs cookies and returns them to your app. You can then use these cookies
 * to freely navigate to this website with your favorite programming language. To successfully
 * bypass these kinds of bot-catching pages, you'll also need User-Agent value of our worker's browser
 * and provide us a proxy of a good quality. Without proxies, this method won't work, as all
 * the anti-bot solutions match their cookies with the IP address of the visitor and their User-Agent.
 *
 * @param websiteURL Address of a target web page.
 * @param proxyAddress Proxy IP address ipv4/ipv6. No host names or IP addresses from local networks.
 * @param proxyPort Proxy port.
 * @param proxyLogin Login for proxy which requires authorization (basic).
 * @param proxyPassword The proxy password.
 */
@Deprecated("This class is not tested !")
data class AntiBotCookiesRequest(
    /**
     * Address of a target web page where our worker will navigate.
     */
    private val websiteURL: String,
    /**
     * Proxy IP address ipv4/ipv6. No host names or IP addresses from local networks.
     */
    private val proxyAddress: String,
    /**
     * Proxy port.
     */
    private val proxyPort: Int,
    /**
     * Login for proxy which requires authorization (basic).
     */
    private val proxyLogin: String,
    /**
     * Proxy password.
     */
    private val proxyPassword: String
) {
    init {
        require(proxyPort in (0..65535))
    }

    private val type = "AntiBotCookieTask"
}
