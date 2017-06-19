package com.trevorwhitney.fakevac.api

import com.trevorwhitney.fakevac.nest.NestService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/status")
class StatusController(val nestService: NestService) {
    @GetMapping
    fun getStatus(): StatusJson {
        return StatusJson(
            internalTemperature = nestService.getTemperature()
        )
    }
}
