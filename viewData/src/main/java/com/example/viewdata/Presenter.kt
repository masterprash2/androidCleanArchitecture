package com.example.viewdata

import com.example.entity.RESULT
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class Presenter @Inject constructor(val viewData: ViewData) {


    fun showLoading() {
        viewData.showLoading()
    }

    fun resetToDefault() {
        viewData.defaultState()
    }

    fun subscribeDataResponse(responsObservable: Observable<RESULT>): Disposable {
        return responsObservable
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { response -> handleDataResponse(response)}
    }

    private fun handleDataResponse(result: RESULT) {
        when (result) {
            RESULT.SUCCESS -> viewData.showSuccess()
            RESULT.FAILURE -> viewData.showNetworkFailure()
            RESULT.NO_NETWORK -> viewData.showConnectionError()
        }
    }


}