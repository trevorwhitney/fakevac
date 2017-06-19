package com.trevorwhitney.fakevac.nest

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.damo.aspen.Test
import org.assertj.core.api.Assertions.assertThat


class NestServiceTest : Test({
    val mockGateway = mock<NestDataGateway>()

    test("#getTemperature") {
        val service = NestService(mockGateway)

        val rootResponse = buildRootResponse(
            thermostatRecord = buildThermostatRecord(ambientTemperatureF = 27)
        )
        doReturn(rootResponse).whenever(mockGateway).getRootResponse()

        val result = service.getTemperature()

        assertThat(result).isEqualTo(27)
        verify(mockGateway).getRootResponse()
    }
})


