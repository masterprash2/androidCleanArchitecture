package com.example.controller

import com.example.interactor.FetchUrlDataInteractor
import com.example.viewdata.Presenter
import com.example.viewdata.ViewData
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class Controller @Inject constructor(
    private val presenter: Presenter,
    private val fetchUrlDataInteractor: FetchUrlDataInteractor,
    private val requestParasm: com.example.entity.UrlRequest
) {

    fun setup() {
        presenter.resetToDefault();
    }

    fun bindFetchUrlActionTo(binding: Observable<Unit>): Disposable {
        val response = binding.switchMap {
            presenter.showLoading()
            fetchUrlDataInteractor.execute(requestParasm)
        }
        return presenter.subscribeDataResponse(response)
    }

    fun bindResetActionTo(binding: Observable<Unit>): Disposable {
        return binding.subscribe { presenter.resetToDefault() }
    }

    fun getViewData(): ViewData {
        return presenter.viewData
    }


}