package net.botlify.anticaptchacom;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import net.botlify.anticaptchacom.request.RecaptchaV3EnterpriseRequest;

import java.util.HashMap;
import java.util.Map;

public class TestClass {

    public static void main(String[] args) throws JsonProcessingException {
        RecaptchaV3EnterpriseRequest request = new RecaptchaV3EnterpriseRequest("url", "key");
        final Map<String, String> myMap = new HashMap<>();
        myMap.put("key", "value");
        request.setEnterprisePayload(myMap);
        final ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(request));

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
