package com.hightech.cryptoapp.main.factories

import android.content.Context
import com.hightech.cryptoapp.main.composite.CryptoFeedLoaderWithFallback

class CryptoFeedCompositeFactory {
  companion object {
    fun createCryptoFeedLoaderWithFallback(context: Context): CryptoFeedLoaderWithFallback {
      return CryptoFeedLoaderWithFallback(
        primary = RemoteCryptoFeedLoaderFactory.createRemoteCryptoFeedLoader(context),
        fallback = LocalCryptoFeedUseCaseFactory.createLoadCryptoFeedLocalUseCase(context),
      )
    }
  }
}