package ru.evgenysidorov.weatherapp.view.weatherlist

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar
import ru.evgenysidorov.weatherapp.MainActivity
import ru.evgenysidorov.weatherapp.binding
import ru.evgenysidorov.weatherapp.model.Repository
import ru.evgenysidorov.weatherapp.model.RepositoryLocalImpl
import ru.evgenysidorov.weatherapp.model.RepositoryRemoteImpl
import ru.evgenysidorov.weatherapp.viewmodel.AppState
import java.lang.IllegalStateException
import java.lang.Thread.sleep
import kotlin.coroutines.coroutineContext

class WeatherListViewModel(private val liveData:MutableLiveData<AppState> = MutableLiveData<AppState>()
): ViewModel() {

   lateinit var repository: Repository

   fun getLiveData():MutableLiveData<AppState>{
      choiceRepository()
      return liveData
   }

   private fun choiceRepository(){
      if (isConnection()){
         repository=RepositoryRemoteImpl()
      } else{
         repository=RepositoryLocalImpl()
      }

   }




   fun sentRequest (){
      if(isConnection())

      liveData.value = AppState.Loading
      try {
         if((0..3).random()==1){
               liveData.postValue(AppState.Error(throw IllegalStateException("что-то пошло не так")))

         }else {
            liveData.postValue(AppState.Success(repository.getWeather(55.54486, 37.644546)))
      }}catch (e: IllegalStateException){
         Toast.makeText(binding.container.context,"Произошла серьезная ошибка",Toast.LENGTH_LONG).show()

      }


      }



   private fun isConnection(): Boolean{
      return false
   }

   }