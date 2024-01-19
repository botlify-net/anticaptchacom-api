package net.botlify.anticaptchacom.api

import net.botlify.anticaptchacom.AntiCaptchaComClient
import net.botlify.anticaptchacom.data.request.TurnstileRequest
import net.botlify.anticaptchacom.data.response.solution.SolveResponse
import net.botlify.anticaptchacom.data.response.solution.TurnstileSolution
import net.botlify.anticaptchacom.exceptions.AntiCaptchaComException
import net.botlify.anticaptchacom.supplier.SolveCaptchaSupplier
import java.io.IOException
import java.util.concurrent.CompletableFuture

/**
 * This api is used to solve captcha.
 */
class SolverAPI internal constructor(
    private val api: AntiCaptchaComClient
) {
    // CloudFlare Turnstile
    @Throws(AntiCaptchaComException::class, IOException::class)
    fun solve(request: TurnstileRequest): SolveResponse<TurnstileSolution> {
        return (solveSynchronized(request, TurnstileSolution::class.java))
    }

    fun solveAsync(request: TurnstileRequest): CompletableFuture<SolveResponse<TurnstileSolution>> {
        return (solveAsynchronous(request, TurnstileSolution::class.java))
    }

    @Throws(AntiCaptchaComException::class, IOException::class)
    private fun <T> solveSynchronized(
        solveRequest: Any,
        clazz: Class<T>
    ): SolveResponse<T> {
        val solveCaptcha = SolveCaptchaSupplier<T>(api, solveRequest, clazz)
        return (solveCaptcha.solve())
    }

    private fun <T> solveAsynchronous(
        solveRequest: Any,
        clazz: Class<T>
    ): CompletableFuture<SolveResponse<T>> {
        val solveCaptcha = SolveCaptchaSupplier<T>(api, solveRequest, clazz)
        return CompletableFuture.supplyAsync(solveCaptcha)
    }
}
