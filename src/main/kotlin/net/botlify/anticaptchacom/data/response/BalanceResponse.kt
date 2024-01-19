package net.botlify.anticaptchacom.data.response

/**
 * The response for the balance request.
 */
data class BalanceResponse(
    /**
     * Account balance value in USD.
     */
    val balance: Double = 0.0
);
