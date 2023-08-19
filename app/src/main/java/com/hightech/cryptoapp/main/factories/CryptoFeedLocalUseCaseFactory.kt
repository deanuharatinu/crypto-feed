package com.hightech.cryptoapp.main.factories

import android.content.Context
import com.hightech.cryptoapp.crypto.feed.cache.usecases.InsertCryptoFeedUseCase
import com.hightech.cryptoapp.crypto.feed.cache.usecases.LoadCryptoFeedLocalUseCase
import com.hightech.cryptoapp.crypto.feed.domain.usecases.CryptoFeedLoader
import com.hightech.cryptoapp.crypto.feed.domain.usecases.InsertCryptoFeed

class CryptoFeedLocalUseCaseFactory {
  companion object {
    fun createLoadCryptoFeedLocalUseCase(context: Context): CryptoFeedLoader {
      val cryptoFeedDao = CryptoFeedDaoFactory.createCryptoFeedDao(context)
      return LoadCryptoFeedLocalUseCase(cryptoFeedDao)
    }

    fun createInsertCryptoFeedUseCase(context: Context): InsertCryptoFeed {
      val cryptoFeedDao = CryptoFeedDaoFactory.createCryptoFeedDao(context)
      return InsertCryptoFeedUseCase(cryptoFeedDao)
    }
  }
}