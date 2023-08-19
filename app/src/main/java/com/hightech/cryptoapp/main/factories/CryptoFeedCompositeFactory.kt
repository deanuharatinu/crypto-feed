package com.hightech.cryptoapp.main.factories

import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedLoader
import com.hightech.cryptoapp.main.composite.CryptoFeedLoaderWithFallback

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