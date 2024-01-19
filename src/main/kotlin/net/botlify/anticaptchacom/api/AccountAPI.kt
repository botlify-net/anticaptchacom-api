package net.botlify.anticaptchacom.api

import net.botlify.anticaptchacom.AntiCaptchaComClient
import net.botlify.anticaptchacom.exceptions.AntiCaptchaComException
import java.io.IOException

@Deprecated("Not implemented yet.")
class AccountAPI(private val api: AntiCaptchaComClient) {

    /**
     * This method returns the balance of the account.
     * @return The balance.
     * @throws AntiCaptchaComException If the request failed.
     * @throws IOException If an I/O error occurred.
     */
    // Account information
    @Throws(AntiCaptchaComException::class, IOException::class)
    fun getBalance() {
        //val client = OkHttpClient()
        //val body = JSONObject()
        //body.put("clientKey", api.config.apiKey)

        //val responseString: String =
        //    api.httpRequester.sendPost(AntiCaptchaComClient.getApiUrl() + "getBalance", body)
        //val mapper = ObjectMapper()
        //return (mapper.readValue(responseString, BalanceResponse::class.java))
    }
}
