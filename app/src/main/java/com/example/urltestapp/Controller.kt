package com.example.urltestapp

import javax.inject.Inject

class Controller @Inject constructor(
    private val presenter: Presenter,
    private val fetchUrlDataInteractor: FetchUrlDataInteractor,
    private val requestParasm : UrlRequest
) {

    fun setup() {
        presenter.resetToDefault();
    }

    fun fetchUrlData() {
        presenter.showLoading()
        presenter.handleDataResponse(fetchUrlDataInteractor.execute(requestParasm))
    }

    fun getViewData(): ViewData {
        return presenter.viewData
    }

}