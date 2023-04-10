package net.botlify.anticaptchacom;

import net.botlify.anticaptchacom.enums.CaptchaServiceType;
import net.botlify.anticaptchacom.response.QueueStatsResponse;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AntiCaptchaComAPITest {

    @Test
    void getQueueStats() throws IOException {
        final QueueStatsResponse response = AntiCaptchaComAPI
                .getQueueStats(CaptchaServiceType.RECAPTCHA_V2_WITHOUT_PROXY);
        assertNotNull(response);
        System.out.println(response);
    }
}