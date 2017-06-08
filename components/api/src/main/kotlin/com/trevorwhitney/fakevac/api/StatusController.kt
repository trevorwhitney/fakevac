package com.trevorwhitney.fakevac.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/status")
class StatusController {
    @GetMapping
    fun getStatus(): StatusJson {
        return StatusJson(
            internalTemperature = 72
        )
    }
}
