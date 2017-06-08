package com.trevorwhitney.fakevac.api

import io.damo.aspen.Test
import org.assertj.core.api.Assertions.assertThat

class StatusControllerTest : Test({
    val controller = StatusController()

    test("GET /status") {
        val response = controller.getStatus()

        assertThat(response).isEqualTo(StatusJson(internalTemperature = 72))
    }
})
