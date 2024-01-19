package net.botlify.anticaptchacom.response.solution;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import net.botlify.anticaptchacom.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomTaskResponseTest {

  @Test
  @SneakyThrows
  public void testParseJson() {
    final String fileName = "response/turnstileTaskResponse.json";
    final String fileContent = TestUtils.readResourceFile(fileName);
    System.out.println(fileContent);

    final ObjectMapper mapper = new ObjectMapper();
    final TypeReference<SolveResponse<TurnstileSolution>> typeReference = new TypeReference<>() {};
    final SolveResponse<TurnstileSolution> response = mapper.readValue(fileContent, typeReference);
    assertNotNull(response);
    assertNotNull(response.getSolution());
  }

}