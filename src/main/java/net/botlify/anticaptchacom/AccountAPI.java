package net.botlify.anticaptchacom;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import net.botlify.anticaptchacom.exceptions.AntiCaptchaComException;
import net.botlify.anticaptchacom.response.AppStatsResponse;
import net.botlify.anticaptchacom.response.BalanceResponse;
import net.botlify.anticaptchacom.response.SpendingStatsResponse;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.io.IOException;

public class AccountAPI {

    @Getter @NotNull
    private final AntiCaptchaComAPI api;

    AccountAPI(@NotNull final AntiCaptchaComAPI api) {
        this.api = api;
    }

    // Account information

    /**
     * This method return the balance of the account.
     * @return The balance.
     * @throws AntiCaptchaComException If the request failed.
     * @throws IOException If an I/O error occurred.
     */
    public @NotNull BalanceResponse getBalance() throws AntiCaptchaComException, IOException {
        final OkHttpClient client = new OkHttpClient();
        final JSONObject body = new JSONObject();
        body.put("clientKey", api.getConfig().getApiKey());

        final String responseString = api.sendPost(client, "https://api.anti-captcha.com/getBalance", body);
        final ObjectMapper mapper = new ObjectMapper();
        return (mapper.readValue(responseString, BalanceResponse.class));
    }

    @Deprecated
    public @NotNull AppStatsResponse getAppStats() {
        return (null);
    }

    @Deprecated
    public @NotNull SpendingStatsResponse getSpendingStats() {
        return (null);
    }

}
