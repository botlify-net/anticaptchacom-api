package net.botlify.anticaptchacom.api;

import net.botlify.anticaptchacom.AntiCaptchaComAPI;
import net.botlify.anticaptchacom.supplier.SolveCaptchaSupplier;
import net.botlify.anticaptchacom.exceptions.AntiCaptchaComException;
import net.botlify.anticaptchacom.request.*;
import net.botlify.anticaptchacom.response.solution.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This api is used to solve captcha.
 */
public class SolverAPI {

  /**
   * The API to use for reporting.
   */
  @NotNull
  private final AntiCaptchaComAPI api;

  /**
   * Construct a new {@link ReporterAPI}.
   *
   * @param api The API to use.
   */
  public SolverAPI(@NotNull final AntiCaptchaComAPI api) {
    this.api = api;
  }

  // Image to text

  public @NotNull SolveResponse<ImageToTextSolution> solve(@NotNull final ImageToTextRequest request)
      throws AntiCaptchaComException, IOException {
    return (solveSynchronized(request));
  }

  public @NotNull CompletableFuture<SolveResponse<ImageToTextSolution>> solveAsync(@NotNull final ImageToTextRequest request) {
    return (this.solveAsynchronous(request));
  }

  // Recaptcha V2

  public @NotNull SolveResponse<RecaptchaSolution> solve(@NotNull final RecaptchaV2Request request)
      throws AntiCaptchaComException, IOException {
    return (solveSynchronized(request));
  }

  public @NotNull CompletableFuture<SolveResponse<RecaptchaSolution>> solveAsync(@NotNull final RecaptchaV2Request request) {
    return (solveAsynchronous(request));
  }

  // Recaptcha V2 Proxy

  public @NotNull SolveResponse<RecaptchaSolution> solve(@NotNull final RecaptchaV2ProxyRequest request)
      throws AntiCaptchaComException, IOException {
    return (solveSynchronized(request));
  }

  public @NotNull CompletableFuture<SolveResponse<RecaptchaSolution>> solveAsync(@NotNull final RecaptchaV2ProxyRequest request) {
    return (solveAsynchronous(request));
  }

  // Recaptcha V2 Enterprise

  public @NotNull SolveResponse<RecaptchaSolution> solve(@NotNull final RecaptchaV2EnterpriseRequest request)
      throws AntiCaptchaComException, IOException {
    return (solveSynchronized(request));
  }

  public @NotNull CompletableFuture<SolveResponse<RecaptchaSolution>> solveAsync(@NotNull final RecaptchaV2EnterpriseRequest request) {
    return (solveAsynchronous(request));
  }

  // Recaptcha V2 Enterprise Proxy

  public @NotNull SolveResponse<RecaptchaSolution> solve(@NotNull final RecaptchaV2EnterpriseProxyRequest request)
      throws AntiCaptchaComException, IOException {
    return (solveSynchronized(request));
  }

  public @NotNull CompletableFuture<SolveResponse<RecaptchaSolution>> solveAsync(@NotNull final RecaptchaV2EnterpriseProxyRequest request) {
    return (solveAsynchronous(request));
  }

  // Recaptcha V3

  public @NotNull SolveResponse<RecaptchaSolution> solve(@NotNull final RecaptchaV3Request request)
      throws AntiCaptchaComException, IOException {
    return (solveSynchronized(request));
  }

  public @NotNull CompletableFuture<SolveResponse<RecaptchaSolution>> solveAsync(@NotNull final RecaptchaV3Request request) {
    return (solveAsynchronous(request));
  }

  // Recaptcha V3 Enterprise

  public @NotNull SolveResponse<RecaptchaSolution> solve(@NotNull final RecaptchaV3EnterpriseRequest request)
      throws AntiCaptchaComException, IOException {
    return (solveSynchronized(request));
  }

  public @NotNull CompletableFuture<SolveResponse<RecaptchaSolution>> solveAsync(@NotNull final RecaptchaV3EnterpriseRequest request) {
    return (solveAsynchronous(request));
  }

  // Fun captcha

  public @NotNull SolveResponse<FunCaptchaSolution> solve(@NotNull final FunCaptchaRequest request)
      throws AntiCaptchaComException, IOException {
    return (solveSynchronized(request));
  }

  public @NotNull CompletableFuture<SolveResponse<FunCaptchaSolution>> solveAsync(@NotNull final FunCaptchaRequest request) {
    return (solveAsynchronous(request));
  }

  // Fun captcha proxy

  public @NotNull SolveResponse<FunCaptchaSolution> solve(@NotNull final FunCaptchaProxyRequest request)
      throws AntiCaptchaComException, IOException {
    return (solveSynchronized(request));
  }

  public @NotNull CompletableFuture<SolveResponse<FunCaptchaSolution>> solveAsync(@NotNull final FunCaptchaProxyRequest request) {
    return (solveAsynchronous(request));
  }

  // TODO: GeeTest

  // Custom Task

  @Deprecated
  public @NotNull SolveResponse<CustomTaskResponse> solve(@NotNull final CustomTaskRequest request) throws AntiCaptchaComException, IOException {
    return (solveSynchronized(request));
  }

  @Deprecated
  public @NotNull CompletableFuture<SolveResponse<CustomTaskResponse>> solveAsync(@NotNull final CustomTaskRequest request) {
    return (solveAsynchronous(request));
  }


  // CloudFlare Turnstile

  public @NotNull SolveResponse<TurnstileSolution> solve(@NotNull final TurnstileRequest request) throws AntiCaptchaComException, IOException {
    return (solveSynchronized(request));
  }

  public @NotNull CompletableFuture<SolveResponse<TurnstileSolution>> solveAsync(@NotNull final TurnstileRequest request) {
    return (solveAsynchronous(request));
  }

  /**
   * Solve a captcha synchronously.
   *
   * @param solveRequest The request to solve.
   * @param <T>          The type of the solution.
   * @return The response.
   * @throws AntiCaptchaComException If an error occurred while solving the captcha.
   * @throws IOException             If an I/O error occurred.
   */
  private <T> @NotNull SolveResponse<T> solveSynchronized(@NotNull final SolveRequest solveRequest)
      throws AntiCaptchaComException, IOException {
    final SolveCaptchaSupplier<T> solveCaptcha = new SolveCaptchaSupplier<>(api, solveRequest);
    return (solveCaptcha.solve());
  }

  /**
   * Solve a captcha asynchronously.
   *
   * @param solveRequest The request to solve.
   * @param <T>          The type of the solution.
   * @return The response.
   */
  private <T> @NotNull CompletableFuture<SolveResponse<T>> solveAsynchronous(@NotNull final SolveRequest solveRequest) {
    final SolveCaptchaSupplier<T> solveCaptcha = new SolveCaptchaSupplier<>(api, solveRequest);
    return CompletableFuture.supplyAsync(solveCaptcha);
  }

}
