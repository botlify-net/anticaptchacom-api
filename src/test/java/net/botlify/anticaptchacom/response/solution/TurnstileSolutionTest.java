package net.botlify.anticaptchacom.response.solution;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import net.botlify.anticaptchacom.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurnstileSolutionTest {

  @Test
  @SneakyThrows
  public void testParseJson() {
    final String fileName = "response/customTaskResponse.json";
    final String fileContent = TestUtils.readResourceFile(fileName);

    final ObjectMapper mapper = new ObjectMapper();
    final CustomTaskResponse response = mapper.readValue(fileContent, CustomTaskResponse.class);
  }

}