package com.hightech.cryptoapp.crypto.feed.http.usecases

import android.util.Log
import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedItemsMapper
import com.hightech.cryptoapp.crypto.feed.domain.usecases.CryptoFeedLoader
import com.hightech.cryptoapp.crypto.feed.domain.usecases.CryptoFeedResult
import com.hightech.cryptoapp.crypto.feed.http.ConnectivityException
import com.hightech.cryptoapp.crypto.feed.http.CryptoFeedHttpClient
import com.hightech.cryptoapp.crypto.feed.http.HttpClientResult
import com.hightech.cryptoapp.crypto.feed.http.InvalidDataException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoadCryptoFeedRemoteUseCase(
  private val cryptoFeedHttpClient: CryptoFeedHttpClient
) : CryptoFeedLoader {
  override fun load(): Flow<CryptoFeedResult> = flow {
    cryptoFeedHttpClient.get().collect { result ->
      when (result) {
        is HttpClientResult.Success -> {
          val cryptoFeed = result.root.data
          if (cryptoFeed.isNotEmpty()) {
            val cryptoFeedItem = CryptoFeedItemsMapper.map(cryptoFeed)
            emit(CryptoFeedResult.Success(cryptoFeedItem))
          } else {
            emit(CryptoFeedResult.Success(emptyList()))
          }
        }

        is HttpClientResult.Failure -> {
          Log.d("loadCryptoFeed", "Failure")
          when (result.throwable) {
            is ConnectivityException -> {
              emit(CryptoFeedResult.Failure(Connectivity()))
            }

            is InvalidDataException -> {
              Log.d("loadCryptoFeed", "InvalidData")
              emit(CryptoFeedResult.Failure(InvalidData()))
            }
          }
        }

        else -> {}
      }
    }
  }
}

class InvalidData : Throwable()
class Connectivity : Throwable()