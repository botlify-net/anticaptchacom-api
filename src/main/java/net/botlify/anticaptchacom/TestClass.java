package net.botlify.anticaptchacom;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import net.botlify.anticaptchacom.response.solution.SolveResponse;
import org.json.JSONObject;

public class TestClass {

    public static void main(String[] args) throws JsonProcessingException {

    }

    public static class MyRequest {

        @Getter
        private final String str;

        @Getter
        private final MySubRequest subRequest;

        public MyRequest(String str, MySubRequest subRequest) {
            this.str = str;
            this.subRequest = subRequest;
        }

    }

    public static class MySubRequest {

        @Getter
        private final String str;

        public MySubRequest(String str) {
            this.str = str;
        }

    }

}
