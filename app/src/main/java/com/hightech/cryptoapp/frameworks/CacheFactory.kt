package com.hightech.cryptoapp.frameworks

import android.content.Context
import androidx.room.Room
import com.hightech.cryptoapp.main.db.AppDatabase

object CacheFactory {
  @Volatile
  private var INSTANCE: AppDatabase? = null

  fun createDatabase(context: Context): AppDatabase {
    synchronized(this) {
      var instance = INSTANCE

      if (instance == null) {
        instance = Room.databaseBuilder(
          context.applicationContext,
          AppDatabase::class.java,
          "database_app"
        ).build()

        INSTANCE = instance
      }
      return instance
    }
  }
}
