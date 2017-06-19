package com.trevorwhitney.fakevac.nest

import org.springframework.stereotype.Service

@Service
class NestService(val dataGateway: NestDataGateway) {
    fun getTemperature() : Int {
        val rootResponse = dataGateway.getRootResponse()
        return getTemperatureForFirstThermostat(rootResponse.devices)
    }

    private fun getTemperatureForFirstThermostat(devices: Devices): Int {
        val firstThermostat = devices.thermostats.values.toList()[0]
        return firstThermostat.ambientTemperatureF
    }
}

