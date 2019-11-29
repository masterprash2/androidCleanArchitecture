package com.example.urltestapp

import android.content.Context
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.net.HttpURLConnection
import java.net.URL

class UrlConnectionNetworkGateway(context: Context) : NetworkGateway {
    override fun loadUrl(url: String): Observable<Result<ByteArray>> {
        return Observable.create <Result<ByteArray>>{ emmiter ->
            try {
                val openConnection = URL(url).openConnection() as HttpURLConnection
                openConnection.connect()
                val responseCode = openConnection.responseCode

                emmiter.onNext(Result.success(("" + responseCode).toByteArray(Charsets.UTF_8)))
            }
            catch (e : Exception) {
                e.printStackTrace()
                emmiter.onNext(Result.failure(e))
            }
        }.subscribeOn(Schedulers.io())
    }

}