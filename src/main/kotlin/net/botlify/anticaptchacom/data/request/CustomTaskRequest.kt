package net.botlify.anticaptchacom.data.request

/**
 * This is a type of task where your app provides a page URL address and a custom
 * assignment for our workers. They complete it step by step and then return their
 * complete browser fingerprint and cookies to your app, which it can use to continue the session.
 */
@Deprecated("This class is not tested !")
class CustomTaskRequest(
    val websiteURL: String,
    val templateName: String,
    val variables: Map<String, String>
) {
    val type: String = "AntiGateTask"

    var domainsOfInterest: List<String>? = null

    /**
     * The proxy address to use for the worker.
     */
    var proxyAddress: String? = null

    /**
     * The proxy port to use for the worker.
     */
    var proxyPort: Int = 0

    /**
     * The proxy login to use for the worker.
     */
    var proxyLogin: String? = null

    /**
     * The proxy password to use for the worker.
     */
    var proxyPassword: String? = null

    /**
     * Set the proxy address and port.
     *
     * @param proxyAddress The proxy address to use for the worker.
     * @param proxyPort    The proxy port to use for the worker.
     */
    fun setProxyAddressAndPort(
        proxyAddress: String,
        proxyPort: Int
    ) {
        require(proxyPort in 1..65535) { "Invalid port number" }
        this.proxyAddress = proxyAddress
        this.proxyPort = proxyPort
    }

    /**
     * Set the proxy login and password.
     *
     * @param proxyLogin    The proxy login to use for the worker.
     * @param proxyPassword The proxy password to use for the worker.
     */
    fun setProxyLoginAndPassword(
        proxyLogin: String,
        proxyPassword: String
    ) {
        this.proxyLogin = proxyLogin
        this.proxyPassword = proxyPassword
    }
}
