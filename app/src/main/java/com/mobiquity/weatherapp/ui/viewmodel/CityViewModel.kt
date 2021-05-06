package com.mobiquity.weatherapp.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.mobiquity.weatherapp.network.model.WeatherModel
import com.mobiquity.weatherapp.network.repository.CityRepository

class CityViewModel(application: Application) : AndroidViewModel(application) {
    val cityModelObserver: MutableLiveData<WeatherModel> = MutableLiveData()
    private var cityRepo: CityRepository? = null
    init {
        cityRepo = CityRepository(application)
    }
    fun getDataFromRepo(city : String) {
        cityRepo?.requestForWeatherDataByCity(cityModelObserver, city)
    }
}