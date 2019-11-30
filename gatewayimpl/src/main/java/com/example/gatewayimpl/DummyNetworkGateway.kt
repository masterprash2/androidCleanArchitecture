package com.example.gatewayimpl

import com.example.gateway.NetworkGateway
import io.reactivex.Observable

class DummyNetworkGateway : NetworkGateway {
    override fun loadUrl(url: String): Observable<Result<ByteArray>> {
        return Observable.just(Result.success("".toByteArray(Charsets.UTF_8)))
    }

}