package com.trevorwhitney.fakevac.nest

data class RootResponse(
    val devices: Devices,
    val structures: Structures,
    val metadata: MetadataRecord
)

data class Devices(
    val thermostats: Map<String, ThermostatRecord>
)

data class Structures(
    val structures: Map<String, StructureRecord>
)

data class MetadataRecord(
    val accessToken: String,
    val clientVersion: Int
)
