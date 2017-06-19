package com.trevorwhitney.fakevac.nest

import com.nhaarman.mockito_kotlin.*
import io.damo.aspen.Test
import okhttp3.*
import org.assertj.core.api.Assertions.assertThat

class NestDataGatewayTest : Test({
    val httpClient = mock<OkHttpClient>()
    val call = mock<Call>()

    before {
        doReturn(call).whenever(httpClient).newCall(any<Request>())
    }

    test {
        val thermostatRecord = buildThermostatRecord()
        thermostatRecord.toJson()
    }

    test("getRootResponse") {
        val rootResponse = buildRootResponse()
        val response = buildOkHttpResponse(rootResponse.toJson())
        doReturn(response).whenever(call).execute()

        val config = NestConfig(rootUrl = "http://example.com")
        val dataGateway = NestDataGateway(config, httpClient)
        val result = dataGateway.getRootResponse()

        assertThat(result).isEqualTo(rootResponse)
        verify(httpClient).newCall(check {
          val headers: Headers = it.headers()
            assertThat(headers.size()).isEqualTo(2)
            assertThat(headers.get("Content-Type")).isEqualTo("application/json")
            assertThat(headers.get("Accept")).isEqualTo("application/json")
            assertThat(it.url()).isEqualTo("http://example.com")
        })

    }
})

fun buildOkHttpResponse(body: String): Response {
    val responseBody = ResponseBody.create(MediaType.parse("application/json"), body)
    return Response.Builder()
        .request(mock<Request>())
        .protocol(mock<Protocol>())
        .addHeader("Content-Type", "application/json")
        .body(responseBody)
        .code(200)
        .build()
}

fun Any.toJson(): String {
    return ""
}
