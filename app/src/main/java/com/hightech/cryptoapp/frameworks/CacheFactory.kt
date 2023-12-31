package com.hightech.cryptoapp.frameworks

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hightech.cryptoapp.crypto.feed.cache.CryptoFeedDao
import com.hightech.cryptoapp.crypto.feed.cache.LocalCryptoFeedItem

class CacheFactory {
  @Database(
    entities = [LocalCryptoFeedItem::class],
    version = 1,
    exportSchema = false
  )
  abstract class AppDatabase : RoomDatabase() {
    abstract fun cryptoFeedDao(): CryptoFeedDao
  }

  companion object {
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
}
