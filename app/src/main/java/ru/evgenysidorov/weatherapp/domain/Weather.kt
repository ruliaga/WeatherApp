package ru.evgenysidorov.weatherapp.domain

data class Weather (
    val city:City = getDefaultCity(),
    val temperature: Int =20,
    val feelsLike: Int=20
)

data class City(
    val name:String,
    val lat: Double,
    val lon: Double
)
fun getDefaultCity()= City("Пермь",55.54486,37.644546)