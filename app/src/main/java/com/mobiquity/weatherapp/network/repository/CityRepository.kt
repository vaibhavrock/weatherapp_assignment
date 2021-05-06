package com.mobiquity.weatherapp.network.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mobiquity.weatherapp.network.api.NetworkApiServices
import com.mobiquity.weatherapp.network.model.WeatherModel
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class CityRepository(val application: Application) {

    fun requestForWeatherDataByCity(weatherModelObserver: MutableLiveData<WeatherModel>?,city: String) {

            val call = NetworkApiServices.create().getWeatherByCity(city, AppId)
            call.enqueue(object : Callback, retrofit2.Callback<WeatherModel> {
                override fun onResponse(call: Call<WeatherModel>, response: Response<WeatherModel>) {
                    if (response.code() == 200) {
                        val weatherResponse = response.body()
                        weatherModelObserver?.let {it.value = (weatherResponse)}
                        Log.i("data", "" + weatherResponse)

                    } else {
                        Log.i("data", "error- " + response.code());
                    }
                }

                override fun onFailure(call: Call<WeatherModel>, t: Throwable) {
                    Log.i("data", "error- " + t.message);
                }
            })

    }

    companion object {
        var AppId = "7dc8b0fb6628d924329062be61bdd9be"
    }


}
