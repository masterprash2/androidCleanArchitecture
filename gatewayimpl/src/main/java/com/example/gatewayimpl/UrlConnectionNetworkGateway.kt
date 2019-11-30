package com.example.gatewayimpl

import android.content.Context
import com.example.gateway.NetworkGateway
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.net.HttpURLConnection
import java.net.URL

class UrlConnectionNetworkGateway(context: Context) : NetworkGateway {

    override fun loadUrl(url: String): Observable<Result<ByteArray>> {
        return Observable.fromCallable {
            val openConnection = URL(url).openConnection() as HttpURLConnection
            Result.success(("" + openConnection.responseCode).toByteArray(Charsets.UTF_8))
        }.onErrorReturn {
            it.printStackTrace()
            Result.failure(it)
        }.subscribeOn(Schedulers.io())
    }

}