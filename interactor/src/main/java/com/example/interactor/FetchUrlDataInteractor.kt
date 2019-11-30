package com.example.interactor

import com.example.entity.RESULT
import com.example.entity.UrlRequest
import com.example.gateway.ConnectionGateway
import com.example.gateway.NetworkGateway
import com.example.gateway.scopes.AppScope
import io.reactivex.Observable
import javax.inject.Inject

@AppScope
class FetchUrlDataInteractor @Inject constructor(
    private val networkGateway: NetworkGateway,
    private val connectionGateway: ConnectionGateway
) {



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