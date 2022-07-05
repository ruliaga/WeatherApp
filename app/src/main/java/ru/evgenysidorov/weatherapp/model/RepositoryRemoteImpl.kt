package ru.evgenysidorov.weatherapp.model

import ru.evgenysidorov.weatherapp.domain.Weather
import ru.evgenysidorov.weatherapp.viewmodel.AppState

class RepositoryRemoteImpl: Repository {
    override fun getListWeather(): List<Weather> {
        Thread{
            Thread.sleep(200L)

        }.start()
        return listOf(Weather())
    }

    override fun getWeather(lat: Double, lon: Double): Weather {
        Thread{
            Thread.sleep(300L)

        }.start()
        return  Weather()
    }
}