package com.hightech.cryptoapp.crypto.feed.cache.usecases

import com.hightech.cryptoapp.crypto.feed.cache.CryptoFeedDao
import com.hightech.cryptoapp.crypto.feed.cache.LocalCryptoFeedItem.Companion.fromDomain
import com.hightech.cryptoapp.crypto.feed.domain.model.CryptoFeedItem
import com.hightech.cryptoapp.crypto.feed.domain.usecases.InsertCryptoFeed

class InsertCryptoFeedUseCase(private val cryptoFeedDao: CryptoFeedDao) : InsertCryptoFeed {
  override suspend fun insert(cryptoFeedItems: List<CryptoFeedItem>) {
    val localCryptoFeedItem = cryptoFeedItems.fromDomain()
    cryptoFeedDao.insertAll(localCryptoFeedItem)
  }
}