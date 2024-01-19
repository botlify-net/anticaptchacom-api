package net.botlify.anticaptchacom;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class TestUtils {

  @SneakyThrows(IOException.class)
  public static @NotNull String readResourceFile(@NotNull String fileName) {
    final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    try (InputStream inputStream = classLoader.getResourceAsStream(fileName)) {
      if (inputStream == null) {
        throw new IOException("Resource file not found: " + fileName);
      }
      try (InputStreamReader isr = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
           BufferedReader reader = new BufferedReader(isr)) {
        return reader.lines().collect(Collectors.joining(System.lineSeparator()));
      }
    }
  }

}
