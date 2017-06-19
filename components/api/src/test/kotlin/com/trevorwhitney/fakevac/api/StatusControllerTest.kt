package com.trevorwhitney.fakevac.api

import com.nhaarman.mockito_kotlin.*
import com.trevorwhitney.fakevac.nest.NestService
import io.damo.aspen.Test
import org.assertj.core.api.Assertions.assertThat

class StatusControllerTest : Test({
    val nestService = mock<NestService>()
    val controller = StatusController(nestService)

    test("GET /status") {
        doReturn(75).whenever(nestService).getTemperature()
        val response = controller.getStatus()

        assertThat(response).isEqualTo(StatusJson(internalTemperature = 75))
        verify(nestService, times(1)).getTemperature()
    }
})
