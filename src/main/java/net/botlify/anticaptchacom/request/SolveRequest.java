package net.botlify.anticaptchacom.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/**
 * A {@link SolveRequest} is a request to solve a captcha.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface SolveRequest {

    /**
     * The request to solve.
     * @return The request to solve as a {@link JSONObject}.
     */
    @SneakyThrows({JsonProcessingException.class})
    default @NotNull JSONObject requestJson() {
        final ObjectMapper mapper = new ObjectMapper();
        return (new JSONObject(mapper.writeValueAsString(this)));
    }

}
