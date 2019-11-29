package com.example.urltestapp

import javax.inject.Inject

class ControlleFactory @Inject constructor(private val presenter: Presenter,
                       private val fetchUrlDataInteractor: FetchUrlDataInteractor) {

    fun create(requestParasm : UrlRequest) : Controller {
        return Controller(presenter,fetchUrlDataInteractor,requestParasm)
    }

}