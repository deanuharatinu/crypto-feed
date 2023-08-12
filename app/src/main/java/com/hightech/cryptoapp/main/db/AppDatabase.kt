package com.hightech.cryptoapp.main.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hightech.cryptoapp.crypto.feed.db.CryptoFeedDao
import com.hightech.cryptoapp.crypto.feed.db.LocalCryptoFeedItem

@Database(
  entities = [LocalCryptoFeedItem::class],
  version = 1,
  exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
  abstract fun cryptoFeedDao(): CryptoFeedDao
}