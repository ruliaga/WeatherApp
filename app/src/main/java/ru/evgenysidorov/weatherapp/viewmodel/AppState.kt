package ru.evgenysidorov.weatherapp.viewmodel

import ru.evgenysidorov.weatherapp.domain.Weather

sealed class AppState {
    data class Success (val weatherData: Weather):AppState()
    data class Error (val error: Throwable):AppState()
    object Loading: AppState()
}

class AppStateSecond: AppState(){

}