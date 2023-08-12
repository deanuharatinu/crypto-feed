package com.hightech.cryptoapp.main.factories

import android.content.Context
import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedLoader
import com.hightech.cryptoapp.crypto.feed.http.usecases.LoadCryptoFeedRemoteUseCase

class RemoteCryptoFeedLoaderFactory {
  companion object {
    fun createRemoteCryptoFeedLoader(context: Context): CryptoFeedLoader {
      return LoadCryptoFeedRemoteUseCase(
        CryptoFeedHttpClientFactory.createCryptoFeedHttpClient(),
        LocalCryptoFeedUseCaseFactory.createInsertCryptoFeedUseCase(context)
      )
    }
  }
}