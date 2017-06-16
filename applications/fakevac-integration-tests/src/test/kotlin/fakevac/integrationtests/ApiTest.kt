package fakevac.integrationtests

import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.client.WireMock.*
import io.damo.aspen.Test
import org.assertj.core.api.Assertions.assertThat

class ApiTest : Test({
    var testProcesses: TestProcesses? = null
    val serverBaseUrl = baseTestUrl()
    val appPort = 8081
    val wireMockPort = 8082

    before {
        testProcesses = startServers(port = appPort, wireMockPort = wireMockPort)
        WireMock.configureFor("localhost", 8082)
    }

    after {
        testProcesses?.stopAll()
    }

    test {
        val rootResponse = buildRootResponse(ambientTemperature = 75)
        WireMock.stubFor(get(urlEqualTo("/nest"))
            .withHeader("Accept", equalTo("application/json"))
            .willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(rootResponse)))

        val expectedResponse = statusJson(
            internalTemperature = 75
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
