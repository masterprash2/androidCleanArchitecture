package com.example.urltestapp

import android.content.Context
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.net.HttpURLConnection
import java.net.URL

class UrlConnectionNetworkGateway(context: Context) : NetworkGateway {

    override fun loadUrl(url: String): Observable<Result<ByteArray>> {
        return Observable.create<Result<ByteArray>> { emmiter ->

            val openConnection = URL(url).openConnection() as HttpURLConnection
            val responseCode = openConnection.responseCode
            emmiter.onNext(Result.success(("" + responseCode).toByteArray(Charsets.UTF_8)))
            
        }.onErrorReturn {
            it.printStackTrace()
            Result.failure(it)
        }.subscribeOn(Schedulers.io())
    }

}