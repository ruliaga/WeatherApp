package ru.evgenysidorov.weatherapp.domain

data class Weather (
    val city:City = getDefaultCity(),
    val temperature: Int =0,
    val feelsLike: Int=0
)

data class City(
    val city:String,
    val lat: Double,
    val lon: Double
)
fun getDefaultCity()= City("Москва",55.54486,37.644546)