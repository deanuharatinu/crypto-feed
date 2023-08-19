package com.hightech.cryptoapp.main.factories

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.hightech.cryptoapp.crypto.feed.presentation.CryptoFeedViewModel

class ViewModelFactory {
  companion object {
    fun provideViewModel(context: Context): ViewModelProvider.Factory = viewModelFactory {
      val cryptoFeedDecorator = CryptoFeedDecoratorFactory.createCryptoFeedCacheDecorator(
        cryptoFeedLoader = RemoteCryptoFeedLoaderFactory.createRemoteCryptoFeedLoader(),
        cache = LocalCryptoFeedUseCaseFactory.createInsertCryptoFeedUseCase(context),
      )

      val cryptoFeedComposite = CryptoFeedCompositeFactory.createCryptoFeedLoaderWithFallback(
        primary = cryptoFeedDecorator,
        fallback = LocalCryptoFeedUseCaseFactory.createLoadCryptoFeedLocalUseCase(context)
      )

      initializer {
        CryptoFeedViewModel(cryptoFeedComposite)
      }
    }
  }
}