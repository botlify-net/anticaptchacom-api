package net.botlify.anticaptchacom.data.response.solution

import com.fasterxml.jackson.annotation.JsonProperty

@Deprecated("Not implemented yet")
data class CustomTaskResponse(
    @JsonProperty("errorId")
    val errorId: Int,

    @JsonProperty("status")
    val status: String,

    @JsonProperty("solution")
    val solution: Solution,

    @JsonProperty("cost")
    val cost: String,

    @JsonProperty("ip")
    val ip: String,

    @JsonProperty("createTime")
    val createTime: Long,

    @JsonProperty("endTime")
    val endTime: Long,

    @JsonProperty("solveCount")
    val solveCount: Int,

    @JsonProperty("screenshots")
    val screenshots: List<String>,

    @JsonProperty("requestHeaders")
    val requestHeaders: List<String>,

    @JsonProperty("responseHeaders")
    val responseHeaders: List<String>
) {
    data class Solution(
        @JsonProperty("cookies")
        val cookies: Map<String, String>,

        @JsonProperty("localStorage")
        val localStorage: Map<String, String>,

        @JsonProperty("fingerprint")
        val fingerprint: Map<String, String>,

        @JsonProperty("url")
        val url: String,

        @JsonProperty("domain")
        val domain: String,

        @JsonProperty("domainsOfInterest")
        val domainsOfInterest: Map<String, DomainOfInterest>,
    )
    data class DomainOfInterest(
        @JsonProperty("cookies")
        val cookies: Map<String, String>,

        @JsonProperty("localStorage")
        val localStorage: Map<String, String>,

        @JsonProperty("url")
        val url: String,

        @JsonProperty("domain")
        val domain: String,
    )
}
