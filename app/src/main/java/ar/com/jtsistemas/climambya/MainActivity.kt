package ar.com.jtsistemas.climambya

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresPermission
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import ar.com.jtsistemas.climambya.viewmodel.WeatherViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
//noinspection SuspiciousImport


class MainActivity : AppCompatActivity() {

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    @RequiresPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        requestLocationPermission()
        val viewModel = ViewModelProvider(this)[WeatherViewModel::class.java]
        val apiKey = "2c20529060e0ccb0c503891209f5e84f" // Reemplaza con tu clave de OpenWeatherMap

        viewModel.weather.observe(this) { weather ->
            findViewById<TextView>(R.id.textLocation).text = weather.name
            findViewById<TextView>(R.id.textTemperature).text = "${weather.main.temp}°C"
            findViewById<TextView>(R.id.textCondition).text = weather.weather.firstOrNull()?.description ?: "Sin datos"
            findViewById<TextView>(R.id.textHumidity).text = "Humedad: ${weather.main.humidity}%"
            findViewById<TextView>(R.id.textWind).text = "Viento: ${weather.wind.speed} km/h"

            val activities = getRecommendations(weather)
            val container = findViewById<LinearLayout>(R.id.activitiesContainer)
            container.removeAllViews()
            activities.forEach { activity ->
                val textView = TextView(this).apply {
                    text = "• ${activity.name} - ${activity.place}"
                    textSize = 16f
                }
                container.addView(textView)
            }
        }
    }

    @RequiresPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
    private fun requestLocationPermission() {
        val permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if (isGranted) {
                getLastLocation()
            }
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        } else {
            getLastLocation()
        }
    }

    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    private fun getLastLocation() {
        fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
            location?.let {
                val lat = it.latitude
                val lon = it.longitude
                // Aquí puedes llamar a tu ViewModel para obtener el clima
            }
        }
    }
}