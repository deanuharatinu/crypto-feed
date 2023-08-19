package com.hightech.cryptoapp.main.factories

import com.hightech.cryptoapp.crypto.feed.domain.usecases.CryptoFeedLoader
import com.hightech.cryptoapp.crypto.feed.http.usecases.LoadCryptoFeedRemoteUseCase

class RemoteCryptoFeedLoaderFactory {
  companion object {
    fun createRemoteCryptoFeedLoader(): CryptoFeedLoader {
      return LoadCryptoFeedRemoteUseCase(
        CryptoFeedHttpClientFactory.createCryptoFeedHttpClient()
      )
    }
  }
}