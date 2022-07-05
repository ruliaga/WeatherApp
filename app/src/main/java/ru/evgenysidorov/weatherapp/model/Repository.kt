package ru.evgenysidorov.weatherapp.model

import ru.evgenysidorov.weatherapp.domain.Weather

interface Repository {
    fun getListWeather(): List<Weather>
    fun getWeather(lat: Double, lon: Double): Weather
}