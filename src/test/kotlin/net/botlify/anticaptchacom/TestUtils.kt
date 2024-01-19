package net.botlify.anticaptchacom

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import java.util.stream.Collectors

object TestUtils {

    fun readResourceFile(fileName: String): String {
        val classLoader = Thread.currentThread().contextClassLoader
        classLoader.getResourceAsStream(fileName).use { inputStream ->
            if (inputStream == null) {
                throw IOException("Resource file not found: $fileName")
            }
            InputStreamReader(inputStream, StandardCharsets.UTF_8).use { isr ->
                BufferedReader(isr).use { reader ->
                    return reader.lines().collect(
                        Collectors.joining(
                            System.lineSeparator()
                        )
                    )
                }
            }
        }
    }
}
