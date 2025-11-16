package ar.com.jtsistemas.climambya.local

import androidx.room.Database
import androidx.room.RoomDatabase
import ar.com.jtsistemas.climambya.data.model.WeatherEntity

@Database(entities = [WeatherEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}
