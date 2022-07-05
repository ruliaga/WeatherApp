package ru.evgenysidorov.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.evgenysidorov.weatherapp.databinding.ActivityMainBinding
import ru.evgenysidorov.weatherapp.view.weatherlist.WeatherListFragment


lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState==null){
            supportFragmentManager.beginTransaction().replace(R.id.container,WeatherListFragment.newInstance()).commit()
        }





    }
}