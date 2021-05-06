package com.mobiquity.weatherapp.utils

import android.annotation.SuppressLint
import android.app.Service
import android.content.Context
import android.content.Intent
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.os.IBinder

class GetGpsLocation(val mContext: Context?) : Service() , LocationListener {
    internal var isGPSEnabled : Boolean?= false
    internal var isNetworkEnabled : Boolean?= false
    var canGetLocation = false
    internal var location: Location? = null
    internal var latitude: Double? = 0.toDouble()
    internal var longitude: Double? = 0.toDouble()
    private val MIN_DISTANCE_CHANGE_FOR_UPDATES: Long = 10
    private val MIN_TIME_BW_UPDATES = (1000 * 60 * 1).toLong() // 1 minute
    protected var locationManager: LocationManager? = null
    private var provider: String? = null

    init {
        getLocation()
    }

    @SuppressLint("MissingPermission")
    fun getLocation(): Location? {
        try {
            locationManager = mContext?.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            isGPSEnabled = locationManager?.isProviderEnabled(LocationManager.GPS_PROVIDER)
            isNetworkEnabled = locationManager?.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

            if (!isGPSEnabled!! && !isNetworkEnabled!!) {
                // todo: no network provider is enabled
            } else {
                this.canGetLocation = true
                if (isNetworkEnabled!!) {
                    provider = LocationManager.NETWORK_PROVIDER
                    locationManager?.requestLocationUpdates(
                        LocationManager.NETWORK_PROVIDER,
                        MIN_TIME_BW_UPDATES,
                        MIN_DISTANCE_CHANGE_FOR_UPDATES.toFloat(), this
                    )
                    if (locationManager != null) {
                        location = locationManager?.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
                        if (location != null) {
                            latitude = location?.latitude
                            longitude = location?.longitude
                        }
                    }
                }
                if (isGPSEnabled!!) {
                    if (location == null) {
                        locationManager?.requestLocationUpdates(
                            LocationManager.GPS_PROVIDER,
                            MIN_TIME_BW_UPDATES,
                            MIN_DISTANCE_CHANGE_FOR_UPDATES.toFloat(), this
                        )
                        if (locationManager != null) {
                            location = locationManager?.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                            if (location != null) {
                                latitude = location?.latitude
                                longitude = location?.longitude
                            }
                        }
                    }
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return location
    }

    override fun onLocationChanged(location: Location) {}

    override fun onProviderDisabled(provider: String) {}

    override fun onProviderEnabled(provider: String) {}

    override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}

    override fun onBind(arg0: Intent): IBinder? {
        return null
    }
}