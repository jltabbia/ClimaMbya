package ar.com.jtsistemas.climambya.local

import androidx.room.Dao

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(weather: WeatherEntity)

    @Query("SELECT * FROM weather_history ORDER BY timestamp DESC LIMIT 10")
    fun getRecentHistory(): Flow<List<WeatherEntity>>
}
