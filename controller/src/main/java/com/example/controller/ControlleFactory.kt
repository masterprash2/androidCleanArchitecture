package com.example.controller

import com.example.entity.UrlRequest
import com.example.interactor.FetchUrlDataInteractor
import com.example.viewdata.Presenter
import javax.inject.Inject

class ControlleFactory @Inject constructor(private val presenter: Presenter,
                       private val fetchUrlDataInteractor: FetchUrlDataInteractor
) {

    fun create(requestParasm : UrlRequest) : Controller {
        return Controller(presenter, fetchUrlDataInteractor, requestParasm)
    }

}