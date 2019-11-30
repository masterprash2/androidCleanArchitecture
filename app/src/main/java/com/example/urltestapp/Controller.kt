package com.example.urltestapp

import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class Controller @Inject constructor(
    private val presenter: Presenter,
    private val fetchUrlDataInteractor: FetchUrlDataInteractor,
    private val requestParasm: UrlRequest
) {

    fun setup() {
        presenter.resetToDefault();
    }

    fun bindFetchUrlActionTo(binding: Observable<Unit>) : Disposable {
        val response = binding.switchMap {
            presenter.showLoading()
            fetchUrlDataInteractor.execute(requestParasm)
        }
        return presenter.subscribeDataResponse(response)
    }

    fun getViewData(): ViewData {
        return presenter.viewData
    }

    fun bindResetButton(binding: Observable<Unit>) : Disposable {
        return binding.subscribe { presenter.resetToDefault()  }
    }

}