package fakevac.integrationtests

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.assertj.core.api.Assertions
import java.net.ConnectException
import java.time.Instant
import java.time.temporal.ChronoUnit


fun startServer(port: Int = 8081): Process {
    val workingDir = System.getProperty("user.dir")

    val process = ProcessBuilder()
        .command("java", "-jar", "$workingDir/../fakevac-server/build/libs/fakevac-server.jar")
        .env("SERVER_PORT", port.toString())
        .inheritIO()
        .start()

    waitUntilServerIsUp(port)
    return process
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
