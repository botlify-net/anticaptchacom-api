package net.botlify.anticaptchacom

import net.botlify.anticaptchacom.exceptions.AntiCaptchaComException
import net.botlify.anticaptchacom.data.request.TurnstileRequest
import net.botlify.anticaptchacom.data.response.solution.SolveResponse
import net.botlify.anticaptchacom.data.response.solution.TurnstileSolution
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import java.io.IOException

@Deprecated("")
object MainClass {
    val log: Logger = LogManager.getLogger(MainClass::class.java)

    const val url: String =
        "https://auth.permisdeconduire.gouv.fr/realms/formation/protocol/openid-connect/auth?response_type=code&scope=openid%20email%20profile&client_id=formation_1&state=f3YctWd8TknqEzggOws0_ZHg660&redirect_uri=https%3A%2F%2Fpro.permisdeconduire.gouv.fr%2Foidc-callback&nonce=L-ThzCt2NxvzBfnWGDugH-PXxmGC5K7MRppPe7D0nuk"

    const val apiKey: String = "71a5c46d44e92864f40c3ec510921c8f"

    const val captchaKey: String = "0x4AAAAAAAOigzzNCJ7SMJWa"

    @Throws(AntiCaptchaComException::class, IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        log.info("Hello, World!")
        val config = AntiCaptchaComBuilder("71a5c46d44e92864f40c3ec510921c8f")
        val api: AntiCaptchaComClient = config.build()

        val request = TurnstileRequest(url, captchaKey)
        val result: SolveResponse<TurnstileSolution> = api.solverAPI.solve(request)
        log.info("Result: {}", result)
    }
}
