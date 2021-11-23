package com.hqk.lifecycle

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyLocationObserver : LifecycleObserver {

    private var context: Context? = null
    private var locationManager: LocationManager? = null
    private var locationListener: MyLocationListener? = null

    constructor(context: Context) {
        this.context = context
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun startGetLocation() {
        Log.d("hqk", "startGetLocation")
        locationManager = context!!.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationListener = MyLocationListener()

        if (ActivityCompat.checkSelfPermission(
                context!!,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                context!!,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }

        locationManager?.requestLocationUpdates(
            LocationManager.GPS_PROVIDER, 3000, 1f,
            locationListener!!
        )
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun stopGetLocation() {
        Log.d("hqk", "stopGetLocation")
        locationManager!!.removeUpdates(locationListener!!)
    }


    internal class MyLocationListener : LocationListener {
        override fun onLocationChanged(location: Location) {
            Log.d("hqk", "location changed:$location")
        }
        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {}
    }
}