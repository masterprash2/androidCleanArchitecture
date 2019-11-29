package com.example.urltestapp

import io.reactivex.Observable
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

    fun handleDataResponse(responsObservable: Observable<FetchUrlDataInteractor.RESULT>): Disposable? {
        return responsObservable.observeOn(AndroidSchedulers.mainThread()).subscribe { response ->
            when (response) {
                FetchUrlDataInteractor.RESULT.SUCCESS -> viewData.showSuccess()
                FetchUrlDataInteractor.RESULT.FAILURE -> viewData.showNetworkFailure()
                FetchUrlDataInteractor.RESULT.NO_NETWORK -> viewData.showConnectionError()
            }

        }
    }


}