package ar.com.jtsistemas.climambya.viewmodel

import androidx.lifecycle.*
import ar.com.jtsistemas.climambya.data.model.WeatherResponse
import ar.com.jtsistemas.climambya.data.network.RetrofitInstance
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    private val _weather = MutableLiveData<WeatherResponse>()
    val weather: LiveData<WeatherResponse> = _weather

    fun fetchWeather(lat: Double, lon: Double, apiKey: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getCurrentWeather(lat, lon, apiKey)
                _weather.postValue(response)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
