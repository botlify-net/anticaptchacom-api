package net.botlify.anticaptchacom.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The response for the balance request.
 */
@ToString
@EqualsAndHashCode
public class BalanceResponse {

    /**
     * Account balance value in USD.
     */
    @Getter
    public double balance;

}
