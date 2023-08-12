package com.hightech.cryptoapp.main.factories

import com.hightech.cryptoapp.crypto.feed.db.CryptoFeedDao
import com.hightech.cryptoapp.main.db.AppDatabase

class CryptoFeedDaoFactory {
  companion object {
    fun createCryptoFeedDao(appDatabase: AppDatabase): CryptoFeedDao {
      return appDatabase.cryptoFeedDao()
    }
  }
}