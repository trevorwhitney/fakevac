package com.trevorwhitney.fakevac.nest

fun buildRootResponse(
    thermostatRecord: ThermostatRecord = buildThermostatRecord(),
    structureRecord: StructureRecord = buildStructureRecord(),
    metadataRecord: MetadataRecord = buildMetadataRecord()
): RootResponse {
    val thermostats = mapOf("thermostat-1-id" to thermostatRecord)
    val devices = Devices(thermostats = thermostats)
    val structures = Structures(structures = mapOf("structure-1-id" to structureRecord))


    return RootResponse(devices, structures, metadataRecord)
}

fun buildMetadataRecord(): MetadataRecord {
    return MetadataRecord(
        accessToken = "secret-access-token",
        clientVersion = 1
    )
}

fun buildStructureRecord(
    smokeCoAlarms: List<String> = listOf("alarm-1"),
    name: String = "123 Fake St",
    countryCode: String = "US",
    postal_code: String = "80202",
    time_zone: String = "America/Denver",
    away: String = "home",
    thermostats: List<String> = listOf("thermostat-1"),
    structureId: String = "structure-1",
    wheres: List<Where> = listOf(Where(whereId = "id", name = "there"))
): StructureRecord {
    val wheresMap = mapOf(wheres[0].whereId to wheres[0])
    return StructureRecord(
        smokeCoAlarms = smokeCoAlarms,
        name = name,
        countryCode = countryCode,
        postal_code = postal_code,
        time_zone = time_zone,
        away = away,
        thermostats = thermostats,
        structureId = structureId,
        wheres = wheresMap
    )
}

fun buildThermostatRecord(
    humidity: Int = 35,
    locale: String = "en-US",
    temperatureScale: String = "F",
    isUsingEmergencyHeat: Boolean = false,
    hasFan: Boolean = true,
    softwareVersion: String = "5.6.2-3",
    hasLeaf: Boolean = false,
    whereId: String = "living-room-id",
    deviceId: String = "thermostat-id",
    name: String = "Living Room (Nest)",
    canHeat: Boolean = true,
    canCool: Boolean = false,
    targetTemperatureC: Double = 20.5,
    targetTemperatureF: Int = 69,
    targetTemperatureHighC: Int = 24,
    targetTemperatureHighF: Int = 75,
    targetTemperatureLowC: Int = 20,
    targetTemperatureLowF: Int = 68,
    ambientTemperatureC: Double = 20.5,
    ambientTemperatureF: Int = 72,
    awayTemperatureHighC: Int = 24,
    awayTemperatureHighF: Int = 76,
    awayTemperatureLowC: Double = 16.5,
    awayTemperatureLowF: Int = 62,
    ecoTemperatureHighC: Int = 24,
    ecoTemperatureHighF: Int = 76,
    ecoTemperatureLowC: Double = 16.5,
    ecoTemperatureLowF: Int = 62,
    isLocked: Boolean = false,
    lockedTempMinC: Int = 20,
    lockedTempMinF: Int = 68,
    lockedTempMaxC: Int = 22,
    lockedTempMaxF: Int = 72,
    sunlightCorrectionActive: Boolean = false,
    sunlightCorrectionEnabled: Boolean = true,
    structureId: String = "structure-1-id",
    fanTimerActive: Boolean = false,
    fanTimerTimeout: String = "1970-01-01T00:00:00.000Z",
    fanTimerDuration: Int = 15,
    previousHvacMode: String = "heat",
    hvacMode: String = "eco",
    timeToTarget: String = "~0",
    timeToTargetTraining: String = "ready",
    whereName: String = "Living Room",
    label: String = "Nest",
    nameLong: String = "Living Room Thermostat (Nest)",
    isOnline: Boolean = true,
    lastConnection: String = "2017-06-15T13:30:58.420Z",
    hvacState: String = "off"
): ThermostatRecord {
    return ThermostatRecord(
        humidity = humidity,
        locale = locale,
        temperatureScale = temperatureScale,
        isUsingEmergencyHeat = isUsingEmergencyHeat,
        hasFan = hasFan,
        softwareVersion = softwareVersion,
        hasLeaf = hasLeaf,
        whereId = whereId,
        deviceId = deviceId,
        name = name,
        canHeat = canHeat,
        canCool = canCool,
        targetTemperatureC = targetTemperatureC,
        targetTemperatureF = targetTemperatureF,
        targetTemperatureHighC = targetTemperatureHighC,
        targetTemperatureHighF = targetTemperatureHighF,
        targetTemperatureLowC = targetTemperatureLowC,
        targetTemperatureLowF = targetTemperatureLowF,
        ambientTemperatureC = ambientTemperatureC,
        ambientTemperatureF = ambientTemperatureF,
        awayTemperatureHighC = awayTemperatureHighC,
        awayTemperatureHighF = awayTemperatureHighF,
        awayTemperatureLowC = awayTemperatureLowC,
        awayTemperatureLowF = awayTemperatureLowF,
        ecoTemperatureHighC = ecoTemperatureHighC,
        ecoTemperatureHighF = ecoTemperatureHighF,
        ecoTemperatureLowC = ecoTemperatureLowC,
        ecoTemperatureLowF = ecoTemperatureLowF,
        isLocked = isLocked,
        lockedTempMinC = lockedTempMinC,
        lockedTempMinF = lockedTempMinF,
        lockedTempMaxC = lockedTempMaxC,
        lockedTempMaxF = lockedTempMaxF,
        sunlightCorrectionActive = sunlightCorrectionActive,
        sunlightCorrectionEnabled = sunlightCorrectionEnabled,
        structureId = structureId,
        fanTimerActive = fanTimerActive,
        fanTimerTimeout = fanTimerTimeout,
        fanTimerDuration = fanTimerDuration,
        previousHvacMode = previousHvacMode,
        hvacMode = hvacMode,
        timeToTarget = timeToTarget,
        timeToTargetTraining = timeToTargetTraining,
        whereName = whereName,
        label = label,
        nameLong = nameLong,
        isOnline = isOnline,
        lastConnection = lastConnection,
        hvacState = hvacState
    )
}
