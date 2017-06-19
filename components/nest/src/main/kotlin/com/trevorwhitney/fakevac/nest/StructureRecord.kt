package com.trevorwhitney.fakevac.nest

data class StructureRecord(
    val smokeCoAlarms: List<String>,
    val name: String,
    val countryCode: String,
    val postal_code: String,
    val time_zone: String,
    val away: String,
    val thermostats: List<String>,
    val structureId: String,
    val wheres: Map<String, Where>
)

data class Where(
    val whereId: String,
    val name: String
)
