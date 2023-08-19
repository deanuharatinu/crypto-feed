package com.hightech.cryptoapp.main.factories

import com.hightech.cryptoapp.crypto.feed.domain.usecases.CryptoFeedLoader
import com.hightech.cryptoapp.main.composites.CryptoFeedLoaderWithFallback

class CryptoFeedCompositeFactory {
  companion object {
    fun createCryptoFeedLoaderWithFallback(
      primary: CryptoFeedLoader,
      fallback: CryptoFeedLoader
    ): CryptoFeedLoaderWithFallback {
      return CryptoFeedLoaderWithFallback(
        primary = primary,
        fallback = fallback,
      )
    }
  }
}