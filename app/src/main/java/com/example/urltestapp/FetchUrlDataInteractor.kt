package com.example.urltestapp

import com.example.urltestapp.di.AppScope
import io.reactivex.Observable
import javax.inject.Inject

@AppScope
class FetchUrlDataInteractor @Inject constructor(
    private val networkGateway: NetworkGateway,
    private val connectionGateway: ConnectionGateway
) {

    enum class RESULT {
        SUCCESS,
        FAILURE,
        NO_NETWORK
    }

    fun execute(url: UrlRequest): Observable<RESULT> {
//        return Observable.just(Result.success("".toByteArray(Charsets.UTF_8)))
        if (!connectionGateway.isConnected()) {
            return Observable.just(RESULT.NO_NETWORK)
        }

        return networkGateway.loadUrl(url.url)
            .map { result ->
            if (result.isSuccess) {
                RESULT.SUCCESS
            } else {
                RESULT.FAILURE
            }
        }
    }

}