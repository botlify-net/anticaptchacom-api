package net.botlify.anticaptchacom.response.solution

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import net.botlify.anticaptchacom.TestUtils
import net.botlify.anticaptchacom.data.response.solution.CustomTaskResponse
import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull

internal class TurnstileSolutionTest {

    @Test
    fun testParseJson() {
        val fileName = "response/customTaskResponse.json"
        val fileContent: String = TestUtils.readResourceFile(fileName)

        val mapper = jacksonObjectMapper()
        val response: CustomTaskResponse = mapper.readValue(fileContent, CustomTaskResponse::class.java)
        assertNotNull(response)
    }
}