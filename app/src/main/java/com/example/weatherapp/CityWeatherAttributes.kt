package com.example.weatherapp

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class CityWeatherAttributes (
    val location: Location,
    val current: Current
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<CityWeatherAttributes>(json)
    }
}

data class Current (
    @Json(name = "last_updated_epoch")
    val lastUpdatedEpoch: Long,

    @Json(name = "last_updated")
    val lastUpdated: String,

    @Json(name = "temp_c")
    val tempC: Double,

    @Json(name = "temp_f")
    val tempF: Double,

    @Json(name = "is_day")
    val isDay: Long,

    val condition: Condition,

    @Json(name = "wind_mph")
    val windMph: Double,

    @Json(name = "wind_kph")
    val windKph: Double,

    @Json(name = "wind_degree")
    val windDegree: Long,

    @Json(name = "wind_dir")
    val windDir: String,

    @Json(name = "pressure_mb")
    val pressureMB: Double,

    @Json(name = "pressure_in")
    val pressureIn: Double,

    @Json(name = "precip_mm")
    val precipMm: Double,

    @Json(name = "precip_in")
    val precipIn: Double,

    val humidity: Long,
    val cloud: Long,

    @Json(name = "feelslike_c")
    val feelslikeC: Double,

    @Json(name = "feelslike_f")
    val feelslikeF: Double,

    @Json(name = "vis_km")
    val visKM: Double,

    @Json(name = "vis_miles")
    val visMiles: Double,

    val uv: Double,

    @Json(name = "gust_mph")
    val gustMph: Double,

    @Json(name = "gust_kph")
    val gustKph: Double
)

data class Condition (
    val text: String,
    val icon: String,
    val code: Long
)

data class Location (
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double,

    @Json(name = "tz_id")
    val tzID: String,

    @Json(name = "localtime_epoch")
    val localtimeEpoch: Long,

    val localtime: String
)
