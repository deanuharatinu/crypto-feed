package com.hightech.cryptoapp.main.factories

import android.content.Context
import com.hightech.cryptoapp.crypto.feed.db.usecases.InsertCryptoFeedUseCase
import com.hightech.cryptoapp.crypto.feed.db.usecases.LoadCryptoFeedLocalUseCase
import com.hightech.cryptoapp.crypto.feed.domain.usecases.CryptoFeedLoader
import com.hightech.cryptoapp.crypto.feed.domain.usecases.InsertCryptoFeed
import com.hightech.cryptoapp.frameworks.CacheFactory

class LocalCryptoFeedUseCaseFactory {
  companion object {
    fun createLoadCryptoFeedLocalUseCase(context: Context): CryptoFeedLoader {
      val appDatabase = CacheFactory.createDatabase(context)
      val cryptoFeedDao = CryptoFeedDaoFactory.createCryptoFeedDao(appDatabase)
      return LoadCryptoFeedLocalUseCase(cryptoFeedDao)
    }

    fun createInsertCryptoFeedUseCase(context: Context): InsertCryptoFeed {
      val appDatabase = CacheFactory.createDatabase(context)
      val cryptoFeedDao = CryptoFeedDaoFactory.createCryptoFeedDao(appDatabase)
      return InsertCryptoFeedUseCase(cryptoFeedDao)
    }
  }
}