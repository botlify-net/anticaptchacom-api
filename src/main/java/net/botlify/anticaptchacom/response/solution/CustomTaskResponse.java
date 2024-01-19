package net.botlify.anticaptchacom.response.solution;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor(force = true, access = lombok.AccessLevel.PRIVATE)
public class CustomTaskResponse {

  @JsonProperty("errorId")
  private int errorId;

  @NotNull
  @JsonProperty("status")
  private String status;

  @NotNull
  @JsonProperty("solution")
  private Solution solution;

  @Getter
  @ToString
  @EqualsAndHashCode
  public static class Solution {
    @NotNull
    @JsonProperty("cookies")
    private Map<String, String> cookies;

    @NotNull
    @JsonProperty("localStorage")
    private Map<@NotNull String, @NotNull String> localStorage;

    @NotNull
    @JsonProperty("fingerprint")
    private Map<@NotNull String, @NotNull String> fingerprint;

    @NotNull
    @JsonProperty("url")
    private String url;

    @NotNull
    @JsonProperty("domain")
    private String domain;

    @NotNull
    @JsonProperty("domainsOfInterest")
    private Map<@NotNull String, @NotNull DomainOfInterest> domainsOfInterest;

    @Getter
    @ToString
    @EqualsAndHashCode
    public static class DomainOfInterest {
      @JsonProperty("cookies")
      private Map<String, String> cookies;

      @JsonProperty("localStorage")
      private Map<String, String> localStorage;

      @JsonProperty("url")
      private String url;

      @JsonProperty("domain")
      private String domain;
    }

    @NotNull
    @JsonProperty("screenshots")
    private List<@NotNull String> screenshots;

    @NotNull
    @JsonProperty("requestHeaders")
    private List<@NotNull String> requestHeaders;

    @NotNull
    @JsonProperty("responseHeaders")
    private List<@NotNull String> responseHeaders;
  }

  @NotNull
  @JsonProperty("cost")
  private String cost;

  @NotNull
  @JsonProperty("ip")
  private String ip;

  @JsonProperty("createTime")
  private long createTime;

  @JsonProperty("endTime")
  private long endTime;

  @JsonProperty("solveCount")
  private int solveCount;

}
