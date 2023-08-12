package com.hightech.cryptoapp.crypto.feed.db

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface CryptoFeedDao {
  @Upsert
  suspend fun insertAll(vararg localCryptoFeedItem: LocalCryptoFeedItem)

  @Query("SELECT * FROM crypto_feed")
  fun getAll(): Flow<List<LocalCryptoFeedItem>>
}