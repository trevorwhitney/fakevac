package fakevac.integrationtests

import io.damo.aspen.Test
import org.assertj.core.api.Assertions.assertThat

class ApiTest : Test({
    var serverProcess: Process? = null
    val serverBaseUrl = baseTestUrl()

    before {
        serverProcess = startServer()
    }

    after {
        serverProcess?.destroyForcibly()
    }

    test {
        val expectedResponse = statusJson(
            internalTemperature = 72
        )

        val response = httpGet("$serverBaseUrl/status")

        assertThat(response.body().string()).isEqualTo(expectedResponse)
        assertThat(response.header("Content-Type")).contains("application/json")
        assertThat(response.isSuccessful).isEqualTo(true)
    }
})

fun statusJson(internalTemperature: Int): String {
    return StringBuilder("{")
        .append("\"internalTemperature\":$internalTemperature")
        .append("}")
        .toString()
}
