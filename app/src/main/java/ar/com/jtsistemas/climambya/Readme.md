# 🌦️ ClimaMbya

Aplicación Android desarrollada en **Kotlin** que muestra:
- 📍 Geolocalización del usuario
- 🌤️ Clima actual
- 📅 Pronóstico extendido de 7 días
- 🎯 Recomendaciones de actividades según el clima
- 🔔 Alertas meteorológicas automáticas
- ⚙️ Configuración de preferencias del usuario
- 🗂️ Historial local con Room
- 🌍 Soporte multilingüe (español/inglés)

## 🚀 Tecnologías
- Kotlin
- Android Jetpack (ViewModel, LiveData, Room, WorkManager)
- Retrofit + Gson
- Glide
- DataStore

## 📂 Estructura del proyecto
ClimaMbya/
├── data/
│   ├── model/
│   │   ├── WeatherResponse.kt
│   │   ├── ForecastResponse.kt
│   │   ├── Activity.kt
│   │   └── WeatherEntity.kt
│   ├── network/
│   │   ├── WeatherApi.kt
│   │   └── RetrofitInstance.kt
│   └── local/
│       ├── WeatherDao.kt
│       └── AppDatabase.kt
│
├── ui/
│   ├── main/
│   │   ├── MainActivity.kt
│   │   └── MainScreen.kt (si usás Jetpack Compose)
│   ├── forecast/
│   │   ├── ForecastActivity.kt
│   │   ├── ForecastAdapter.kt
│   │   └── item_forecast.xml
│   └── settings/
│       ├── SettingsActivity.kt
│       └── activity_settings.xml
│
├── viewmodel/
│   ├── WeatherViewModel.kt
│   └── ForecastViewModel.kt
│
├── utils/
│   ├── RecommendationUtils.kt
│   └── PreferencesManager.kt
│
├── worker/
│   └── WeatherAlertWorker.kt
│
├── res/
│   ├── layout/
│   │   ├── activity_main.xml
│   │   ├── activity_forecast.xml
│   │   └── activity_settings.xml
│   ├── menu/
│   │   └── main_menu.xml
│   ├── values/
│   │   └── strings.xml
│   └── values-en/
│       └── strings.xml
│
├── AndroidManifest.xml
└── build.gradle