package com.hightech.cryptoapp.main.factories

import com.hightech.cryptoapp.crypto.feed.http.CryptoFeedService
import com.hightech.cryptoapp.frameworks.HttpFactory

class CryptoFeedServiceFactory {
  companion object {
    fun createCryptoFeedService(): CryptoFeedService {
      return HttpFactory.createRetrofit(
        HttpFactory.createMoshi(),
        HttpFactory.createOkhttpClient(
          HttpFactory.createLoggingInterceptor()
        )
      ).create(CryptoFeedService::class.java)
    }
  }
}