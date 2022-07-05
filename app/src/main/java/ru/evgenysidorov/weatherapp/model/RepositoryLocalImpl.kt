package ru.evgenysidorov.weatherapp.model

import ru.evgenysidorov.weatherapp.domain.Weather

class RepositoryLocalImpl: Repository {
    override fun getListWeather(): List<Weather> {
        return listOf(Weather())
    }

    override fun getWeather(lat: Double, lon: Double): Weather {
        return  Weather()
    }
}