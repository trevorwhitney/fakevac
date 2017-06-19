package com.trevorwhitney.fakevac.nest

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

class ThermostatRecordAdapter {
    @FromJson fun thermostatRecordFromJson(json: ThermostatRecordJson): ThermostatRecord {
        return ThermostatRecord(
            humidity = json.humidity,
            locale = json.locale,
            temperatureScale = json.temperature_scale,
            isUsingEmergencyHeat = json.is_using_emergency_heat,
            hasFan = json.has_fan,
            softwareVersion = json.software_version,
            hasLeaf = json.has_leaf,
            whereId = json.where_id,
            deviceId = json.device_id,
            name = json.name,
            canHeat = json.can_heat,
            canCool = json.can_cool,
            targetTemperatureC = json.target_temperature_c,
            targetTemperatureF = json.target_temperature_f,
            targetTemperatureHighC = json.target_temperature_high_c,
            targetTemperatureHighF = json.target_temperature_high_f,
            targetTemperatureLowC = json.target_temperature_low_c,
            targetTemperatureLowF = json.target_temperature_low_f,
            ambientTemperatureC = json.ambient_temperature_c,
            ambientTemperatureF = json.ambient_temperature_f,
            awayTemperatureHighC = json.away_temperature_high_c,
            awayTemperatureHighF = json.away_temperature_high_f,
            awayTemperatureLowC = json.away_temperature_low_c,
            awayTemperatureLowF = json.away_temperature_low_f,
            ecoTemperatureHighC = json.eco_temperature_high_c,
            ecoTemperatureHighF = json.eco_temperature_high_f,
            ecoTemperatureLowC = json.eco_temperature_low_c,
            ecoTemperatureLowF = json.eco_temperature_low_f,
            isLocked = json.is_locked,
            lockedTempMinC = json.locked_temp_min_c,
            lockedTempMinF = json.locked_temp_min_f,
            lockedTempMaxC = json.locked_temp_max_c,
            lockedTempMaxF = json.locked_temp_max_f,
            sunlightCorrectionActive = json.sunlight_correction_active,
            sunlightCorrectionEnabled = json.sunlight_correction_enabled,
            structureId = json.structure_id,
            fanTimerActive = json.fan_timer_active,
            fanTimerTimeout = json.fan_timer_timeout,
            fanTimerDuration = json.fan_timer_duration,
            previousHvacMode = json.previous_hvac_mode,
            hvacMode = json.hvac_mode,
            timeToTarget = json.time_to_target,
            timeToTargetTraining = json.time_to_target_training,
            whereName = json.where_name,
            label = json.label,
            nameLong = json.name_long,
            isOnline = json.is_online,
            lastConnection = json.last_connection,
            hvacState = json.hvac_state
        )
    }

    @ToJson fun thermostatRecordToJson(record: ThermostatRecord): ThermostatRecordJson {
        return ThermostatRecordJson(
            humidity = record.humidity,
            locale = record.locale,
            temperature_scale = record.temperatureScale,
            is_using_emergency_heat = record.isUsingEmergencyHeat,
            has_fan = record.hasFan,
            software_version = record.softwareVersion,
            has_leaf = record.hasLeaf,
            where_id = record.whereId,
            device_id = record.deviceId,
            name = record.name,
            can_heat = record.canHeat,
            can_cool = record.canCool,
            target_temperature_c = record.targetTemperatureC,
            target_temperature_f = record.targetTemperatureF,
            target_temperature_high_c = record.targetTemperatureHighC,
            target_temperature_high_f = record.targetTemperatureHighF,
            target_temperature_low_c = record.targetTemperatureLowC,
            target_temperature_low_f = record.targetTemperatureLowF,
            ambient_temperature_c = record.ambientTemperatureC,
            ambient_temperature_f = record.ambientTemperatureF,
            away_temperature_high_c = record.awayTemperatureHighC,
            away_temperature_high_f = record.awayTemperatureHighF,
            away_temperature_low_c = record.awayTemperatureLowC,
            away_temperature_low_f = record.awayTemperatureLowF,
            eco_temperature_high_c = record.ecoTemperatureHighC,
            eco_temperature_high_f = record.ecoTemperatureHighF,
            eco_temperature_low_c = record.ecoTemperatureLowC,
            eco_temperature_low_f = record.ecoTemperatureLowF,
            is_locked = record.isLocked,
            locked_temp_min_c = record.lockedTempMinC,
            locked_temp_min_f = record.lockedTempMinF,
            locked_temp_max_c = record.lockedTempMaxC,
            locked_temp_max_f = record.lockedTempMaxF,
            sunlight_correction_active = record.sunlightCorrectionActive,
            sunlight_correction_enabled = record.sunlightCorrectionEnabled,
            structure_id = record.structureId,
            fan_timer_active = record.fanTimerActive,
            fan_timer_timeout = record.fanTimerTimeout,
            fan_timer_duration = record.fanTimerDuration,
            previous_hvac_mode = record.previousHvacMode,
            hvac_mode = record.hvacMode,
            time_to_target = record.timeToTarget,
            time_to_target_training = record.timeToTargetTraining,
            where_name = record.whereName,
            label = record.label,
            name_long = record.nameLong,
            is_online = record.isOnline,
            last_connection = record.lastConnection,
            hvac_state = record.hvacState
        )
    }
}

data class ThermostatRecordJson(
    val humidity: Int,
    val locale: String,
    val temperature_scale: String,
    val is_using_emergency_heat: Boolean,
    val has_fan: Boolean,
    val software_version: String,
    val has_leaf: Boolean,
    val where_id: String,
    val device_id: String,
    val name: String,
    val can_heat: Boolean,
    val can_cool: Boolean,
    val target_temperature_c: Double,
    val target_temperature_f: Int,
    val target_temperature_high_c: Int,
    val target_temperature_high_f: Int,
    val target_temperature_low_c: Int,
    val target_temperature_low_f: Int,
    val ambient_temperature_c: Double,
    val ambient_temperature_f: Int,
    val away_temperature_high_c: Int,
    val away_temperature_high_f: Int,
    val away_temperature_low_c: Double,
    val away_temperature_low_f: Int,
    val eco_temperature_high_c: Int,
    val eco_temperature_high_f: Int,
    val eco_temperature_low_c: Double,
    val eco_temperature_low_f: Int,
    val is_locked: Boolean,
    val locked_temp_min_c: Int,
    val locked_temp_min_f: Int,
    val locked_temp_max_c: Int,
    val locked_temp_max_f: Int,
    val sunlight_correction_active: Boolean,
    val sunlight_correction_enabled: Boolean,
    val structure_id: String,
    val fan_timer_active: Boolean,
    val fan_timer_timeout: String,
    val fan_timer_duration: Int,
    val previous_hvac_mode: String,
    val hvac_mode: String,
    val time_to_target: String,
    val time_to_target_training: String,
    val where_name: String,
    val label: String,
    val name_long: String,
    val is_online: Boolean,
    val last_connection: String,
    val hvac_state: String
)
