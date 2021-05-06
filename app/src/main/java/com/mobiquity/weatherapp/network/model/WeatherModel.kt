package com.mobiquity.weatherapp.network.model
import com.google.gson.annotations.SerializedName

data class WeatherModel(val v: String) {
    @SerializedName("coord")
    val coord: Coord? = null

    @SerializedName("weather")
    val weather: List<Weather>? = null

    @SerializedName("base")
    val base: String? = null

    @SerializedName("main")
    val main: Main? = null

    @SerializedName("visibility")
    val visibility: Int? = null

    @SerializedName("wind")
    val wind: Wind? = null

    @SerializedName("clouds")
    val clouds: Clouds? = null

    @SerializedName("dt")
    val dt: Int? = null

    @SerializedName("sys")
    val sys: Sys? = null

    @SerializedName("timezone")
    val timezone: Int? = null

    @SerializedName("id")
    val id: Int? = null

    @SerializedName("name")
    val name: String? = null

    @SerializedName("cod")
    val cod: Int? = null

    @SerializedName("rain")
    val rain: Rain? = null

    data class Main(val v: String) {
        @SerializedName("temp")
        val temp: Double = 0.toDouble()
        @SerializedName("feels_like")
        val feelsLike: Double = 0.toDouble()
        @SerializedName("temp_min")
        val tempMin: Double = 0.toDouble()
        @SerializedName("temp_max")
        val tempMax: Double = 0.toDouble()
        @SerializedName("pressure")
        val pressure: Float = 0.toFloat()
        @SerializedName("humidity")
        val humidity: Float = 0.toFloat()
        @SerializedName("sea_level")
        val seaLevel: Float = 0.toFloat()
        @SerializedName("grnd_level")
        val grndLevel: Float = 0.toFloat()
    }

    data class Coord(val v: String) {
        @SerializedName("lon")
        var lon: Float = 0.toFloat()
        @SerializedName("lat")
        var lat: Float = 0.toFloat()
    }

    data class Clouds(val v: String) {
        @SerializedName("all")
        var all: Float = 0.toFloat()
    }

    data class Wind(val v: String) {
        @SerializedName("speed")
        var speed: Float = 0.toFloat()
        @SerializedName("deg")
        var deg: Float = 0.toFloat()
    }

    data class Sys(val v: String) {
        @SerializedName("country")
        var country: String? = null
        @SerializedName("sunrise")
        var sunrise: Long = 0
        @SerializedName("sunset")
        var sunset: Long = 0
    }

    data class Weather(val v: String) {
        @SerializedName("id")
        var id: Int = 0
        @SerializedName("main")
        var main: String? = null
        @SerializedName("description")
        var description: String? = null
        @SerializedName("icon")
        var icon: String? = null
    }

    data class Rain(val v: String) {
        @SerializedName("3h")
        var h3: Float = 0.toFloat()
    }


}