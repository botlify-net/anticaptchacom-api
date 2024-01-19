package net.botlify.anticaptchacom.supplier

import net.botlify.anticaptchacom.AntiCaptchaComClient
import net.botlify.anticaptchacom.exceptions.AntiCaptchaComException
import net.botlify.anticaptchacom.data.response.solution.SolveResponse
import net.botlify.anticaptchacom.supplier.utils.StartTask
import net.botlify.anticaptchacom.supplier.utils.TaskResponse
import java.io.IOException
import java.util.function.Supplier

/**
 * A [SolveCaptchaSupplier] is a [Supplier] of [SolveResponse].
 * This is used to solve a captcha.
 */
internal class SolveCaptchaSupplier<R>(
    private val api: AntiCaptchaComClient,
    private val request: Any,
    private val clazz: Class<R>,
) : Supplier<SolveResponse<R>> {

    override fun get(): SolveResponse<R> {
        return (solve())
    }

    @Throws(AntiCaptchaComException::class, IOException::class)
    fun solve(): SolveResponse<R> {
        val startTask = StartTask(api, request)
        val taskId = startTask.startTask();
        val response = TaskResponse(api, taskId, clazz)
        return response.getResponse()
    }
}
