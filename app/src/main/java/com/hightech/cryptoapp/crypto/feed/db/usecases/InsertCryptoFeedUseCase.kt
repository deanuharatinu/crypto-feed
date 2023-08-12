package com.hightech.cryptoapp.crypto.feed.db.usecases

import com.hightech.cryptoapp.crypto.feed.db.CryptoFeedDao
import com.hightech.cryptoapp.crypto.feed.db.LocalCryptoFeedItem

class InsertCryptoFeedUseCase(private val cryptoFeedDao: CryptoFeedDao) {
  suspend fun insertAll(vararg cryptoFeedItem: LocalCryptoFeedItem) {
      cryptoFeedDao.insertAll(*cryptoFeedItem)
  }
}