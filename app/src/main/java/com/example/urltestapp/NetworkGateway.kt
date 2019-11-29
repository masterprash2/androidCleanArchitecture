package com.example.urltestapp

import io.reactivex.Observable

interface NetworkGateway {

    fun loadUrl(url : String) : Observable<Result<ByteArray>>

}