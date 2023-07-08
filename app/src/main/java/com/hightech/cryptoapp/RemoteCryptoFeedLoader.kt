package com.hightech.cryptoapp

import com.hightech.cryptoapp.domain.CryptoFeedResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteCryptoFeedLoader constructor(private val httpClient: HttpClient) {
    fun load(): Flow<CryptoFeedResult> = flow {
        httpClient.get().collect { result ->
            if (result is HttpClientResult.Failure) {
                emit(CryptoFeedResult.Failure(InvalidData()))
            }

            if (result is HttpClientResult.Failure) {
                emit(CryptoFeedResult.Failure(Connectivity()))
            }
        }
    }
}

class InvalidData : Throwable()
class Connectivity : Throwable()