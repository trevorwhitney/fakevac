package com.trevorwhitney.fakevac.nest

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi

val thermostatAdapter = Moshi
    .Builder()
    .add(KotlinJsonAdapterFactory())
    .add(ThermostatRecordAdapter::class.java)
    .build()
    .adapter<ThermostatRecord>(ThermostatRecordAdapter::class.java)

class ThermostatRecord(
    val humidity: Int,
    val locale: String,
    val temperatureScale: String,
    val isUsingEmergencyHeat: Boolean,
    val hasFan: Boolean,
    val softwareVersion: String,
    val hasLeaf: Boolean,
    val whereId: String,
    val deviceId: String,
    val name: String,
    val canHeat: Boolean,
    val canCool: Boolean,
    val targetTemperatureC: Double,
    val targetTemperatureF: Int,
    val targetTemperatureHighC: Int,
    val targetTemperatureHighF: Int,
    val targetTemperatureLowC: Int,
    val targetTemperatureLowF: Int,
    val ambientTemperatureC: Double,
    val ambientTemperatureF: Int,
    val awayTemperatureHighC: Int,
    val awayTemperatureHighF: Int,
    val awayTemperatureLowC: Double,
    val awayTemperatureLowF: Int,
    val ecoTemperatureHighC: Int,
    val ecoTemperatureHighF: Int,
    val ecoTemperatureLowC: Double,
    val ecoTemperatureLowF: Int,
    val isLocked: Boolean,
    val lockedTempMinC: Int,
    val lockedTempMinF: Int,
    val lockedTempMaxC: Int,
    val lockedTempMaxF: Int,
    val sunlightCorrectionActive: Boolean,
    val sunlightCorrectionEnabled: Boolean,
    val structureId: String,
    val fanTimerActive: Boolean,
    val fanTimerTimeout: String,
    val fanTimerDuration: Int,
    val previousHvacMode: String,
    val hvacMode: String,
    val timeToTarget: String,
    val timeToTargetTraining: String,
    val whereName: String,
    val label: String,
    val nameLong: String,
    val isOnline: Boolean,
    val lastConnection: String,
    val hvacState: String
) {
    fun toJson() = thermostatAdapter.toJson(this)

    companion object {
        fun fromJson(json: String): ThermostatRecord = thermostatAdapter.fromJson(json)!!
    }
}
