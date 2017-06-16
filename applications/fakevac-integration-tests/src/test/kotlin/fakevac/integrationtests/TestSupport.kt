package fakevac.integrationtests

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.assertj.core.api.Assertions
import java.net.ConnectException
import java.time.Instant
import java.time.temporal.ChronoUnit

class TestProcesses(val process: Process, val wireMockServer: WireMockServer) {
    fun stopAll() {
        process.destroyForcibly()
        wireMockServer.stop()
    }
}

fun startServers(port: Int = 8081, wireMockPort: Int = 8082): TestProcesses {
    val workingDir = System.getProperty("user.dir")

    val process = ProcessBuilder()
        .command("java", "-jar", "$workingDir/../fakevac-server/build/libs/fakevac-server.jar")
        .env("SERVER_PORT", port.toString())
        .env("NEST_URL", "http://localhost:$wireMockPort/nest")
        .inheritIO()
        .start()

    val wireMockServer = WireMockServer(WireMockConfiguration.wireMockConfig().port(wireMockPort))
    wireMockServer.start()

    waitUntilServerIsUp(port)

    return TestProcesses(process, wireMockServer)
}

private fun ProcessBuilder.env(name: String, value: String) = apply { environment()[name] = value }

// timeout in seconds
private fun waitUntilServerIsUp(port: Int, timeout: Int = 20) {
    val start = Instant.now()
    var isUp = false

    while (!isUp) {
        try {
            httpGet("http://localhost:$port")
            isUp = true
        } catch (e: ConnectException) {
            val timeSpent = ChronoUnit.SECONDS.between(start, Instant.now())
            if (timeSpent > timeout) {
                Assertions.fail("Timed out waiting for server on port $port")
            }

            Thread.sleep(200)
        }
    }
}

fun httpGet(url: String): Response {
    val client = OkHttpClient()

    val request = Request.Builder()
        .addHeader("Content-Type", "application/json")
        .addHeader("Accept", "application/json")
        .url(url)
        .build()

    return client.newCall(request).execute()
}

fun baseTestUrl(): String {
    return "http://localhost:8081"

}
