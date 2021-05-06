package com.mobiquity.weatherapp.ui.fragment

import android.R.attr.description
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.mobiquity.weatherapp.R
import com.mobiquity.weatherapp.network.model.WeatherModel
import com.mobiquity.weatherapp.ui.viewmodel.CityViewModel
import kotlinx.android.synthetic.main.fragment_city.*


class CityFragment(var cityName: String) : BaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_city, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeDataFromViewModel(cityName)
    }

    private fun observeDataFromViewModel(city: String) {
        val mViewModel = ViewModelProviders.of(this).get(CityViewModel::class.java)
        mViewModel.getDataFromRepo(city)
        mViewModel.cityModelObserver.observe(this, object : Observer<WeatherModel> {
            override fun onChanged(weatherModel: WeatherModel?) {

                //Log.v("model", "" + weatherModel)

                location.text = weatherModel?.name
                temp.text = "Temp: "+weatherModel?.main?.temp.toString()
                tempMin.text = weatherModel?.main?.tempMin.toString()
                tempMax.text = weatherModel?.main?.tempMax.toString()
                humidity.text = weatherModel?.main?.humidity.toString()
                windSpeed.text = weatherModel?.wind?.speed.toString()
                windDeg.text = weatherModel?.wind?.deg.toString()
                pressure.text = weatherModel?.main?.pressure.toString()
                visibility.text = weatherModel?.visibility.toString()
                sunrise.text = weatherModel?.sys?.sunrise.toString()
                sunset.text = weatherModel?.sys?.sunset.toString()
                descrWeather.text = weatherModel?.weather!![0].description.toString()
                tempCountry.text = "("+weatherModel?.sys?.country.toString()+")"

                val iconUrl = "https://openweathermap.org/img/w/" + weatherModel.weather[0].icon + ".png"
                Glide.with(imgWeather.context).load(iconUrl).placeholder(R.drawable.ic_launcher_foreground).dontAnimate().into(imgWeather);


            }
        })
    }
}