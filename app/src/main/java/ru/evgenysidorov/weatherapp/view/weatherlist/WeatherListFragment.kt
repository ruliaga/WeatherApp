package ru.evgenysidorov.weatherapp.view.weatherlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.evgenysidorov.weatherapp.databinding.FragmentWeatherListBinding
import ru.evgenysidorov.weatherapp.viewmodel.AppState
import ru.evgenysidorov.weatherapp.viewmodel.AppStateSecond

class WeatherListFragment: Fragment() {


    companion object {
        fun newInstance() = WeatherListFragment()
    }

    lateinit var binding: FragmentWeatherListBinding
    lateinit var viewModel: WeatherListViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeatherListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(WeatherListViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner,  object : Observer<AppState>{
            override fun onChanged(t: AppState) {
               renderData(t)
            }
        })
        viewModel.sentRequest()
    }
    private fun renderData (appState: AppState){
        when (appState){

            is AppState.Error -> TODO()
            AppState.Loading -> TODO()
            is AppState.Success -> {
                val result=appState.weatherData
                binding.cityName.text=result.city.name
                binding.temperature.text= result.temperature.toString()
                binding.feelslikeLabel.text=result.feelsLike.toString()
                binding.coordinates.text="${result.city.lat}/${result.city.lon}"

            }
        }
    }
}
