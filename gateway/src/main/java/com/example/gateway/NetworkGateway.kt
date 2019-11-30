package com.example.gateway

import io.reactivex.Observable

interface NetworkGateway {

    fun loadUrl(url : String) : Observable<Result<ByteArray>>

}