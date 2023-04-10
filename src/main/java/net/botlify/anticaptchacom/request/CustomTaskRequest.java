package net.botlify.anticaptchacom.request;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import java.util.List;
import java.util.Map;

/**
 * This is a type of task where your app provides a page URL address and a custom
 * assignment for our workers. They complete it step by step and then return their
 * complete browser fingerprint and cookies to your app, which it can use to continue the session.
 */
public class CustomTaskRequest implements SolveRequest {

    @NotNull @Getter
    private final String type = "AntiGateTask";

    @NotNull @Getter
    private final String websiteURL;

    @NotNull @Getter
    private final String templateName;

    @NotNull @Getter
    private final Map<String, String> variables;

    @Nullable @Getter
    private List<String> domainsOfInterest;

    /**
     * The proxy address to use for the worker.
     */
    @Nullable @Getter
    private String proxyAddress;

    /**
     * The proxy port to use for the worker.
     */
    @Getter
    private int proxyPort;

    /**
     * The proxy login to use for the worker.
     */
    @Nullable @Getter
    private String proxyLogin;

    /**
     * The proxy password to use for the worker.
     */
    @Nullable @Getter
    private String proxyPassword;

    public CustomTaskRequest(@NotNull final String websiteURL,
                             @NotNull final String templateName,
                             @NotNull final Map<String, String> variables) {
        this.websiteURL = websiteURL;
        this.templateName = templateName;
        this.variables = variables;
    }

    public void setDomainsOfInterest(@NotNull final List<String> domainsOfInterest) {
        this.domainsOfInterest = domainsOfInterest;
    }

    /**
     * Set the proxy address and port.
     * @param proxyAddress The proxy address to use for the worker.
     * @param proxyPort The proxy port to use for the worker.
     */
    public void setProxyAddressAndPort(@NotNull final String proxyAddress,
                                       @Range(from = 0, to = 65535) final int proxyPort) {
        this.proxyAddress = proxyAddress;
        this.proxyPort = proxyPort;
    }

    /**
     * Set the proxy login and password.
     * @param proxyLogin The proxy login to use for the worker.
     * @param proxyPassword The proxy password to use for the worker.
     */
    public void setProxyLoginAndPassword(@NotNull final String proxyLogin,
                                         @NotNull final String proxyPassword) {
        this.proxyLogin = proxyLogin;
        this.proxyPassword = proxyPassword;
    }

}
