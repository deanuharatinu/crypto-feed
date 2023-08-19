package com.hightech.cryptoapp.crypto.feed.cache

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface CryptoFeedDao {
  @Upsert
  suspend fun insertAll(localCryptoFeedItem: List<LocalCryptoFeedItem>)

  @Query("SELECT * FROM crypto_feed")
  fun getAll(): Flow<List<LocalCryptoFeedItem>>
}