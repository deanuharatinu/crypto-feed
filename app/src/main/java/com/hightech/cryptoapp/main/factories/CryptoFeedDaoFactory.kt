package com.hightech.cryptoapp.main.factories

import android.content.Context
import com.hightech.cryptoapp.crypto.feed.cache.CryptoFeedDao
import com.hightech.cryptoapp.frameworks.CacheFactory

class CryptoFeedDaoFactory {
  companion object {
    fun createCryptoFeedDao(context: Context): CryptoFeedDao {
      return createAppDatabase(context).cryptoFeedDao()
    }

    private fun createAppDatabase(context: Context): CacheFactory.AppDatabase {
      return CacheFactory.createDatabase(context)
    }
  }
}