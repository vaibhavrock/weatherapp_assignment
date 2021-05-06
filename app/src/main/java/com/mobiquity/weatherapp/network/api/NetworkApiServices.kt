package com.mobiquity.weatherapp.network.api

import com.mobiquity.weatherapp.network.model.WeatherModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkApiServices {

    //http://api.openweathermap.org/data/2.5/weather?q=Noida&appid=fae7190d7e6433ec3a45285ffcf55c86
    @GET("data/2.5/weather?")
    fun getWeatherByCity(@Query("q") city: String, @Query("APPID") app_id: String): Call<WeatherModel>

    companion object Factory {
        var BASE_URL = "https://api.openweathermap.org/"

        fun create(): NetworkApiServices {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(NetworkApiServices::class.java);
        }
    }
}