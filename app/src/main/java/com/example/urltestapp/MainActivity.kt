package com.example.urltestapp

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    //    android:onClick="@{() -> model.onRetryClicked()}"
//    android:visibility="@{data.isLoading() ? View.VISIBLE : View.GONE}"
//    app:title="@{data.toolbarTitle}"
//    <layout xmlns:android="http://schemas.android.com/apk/res/android"
//    xmlns:app="http://schemas.android.com/apk/res-auto"
//    xmlns:tools="http://schemas.android.com/tools">
//
//    <data>
//    <variable name="model"
//    type="com.skyscanner.viewmodel.results.SearchResultsViewModel"/>
//    <variable name="data"
//    type="com.skyscanner.viewmodel.results.data.SearchResultsData"/>
//    <import type="android.view.View"/>
//    </data>


    var viewHolder: ViewHolder? = null

    @Inject
    lateinit var controllerFactory: ControlleFactory

    lateinit var controller : Controller
//    (
//        Presenter(ViewData()),
//        FetchUrlDataInteractor(DummyNetworkGateway(), DummyConnectionGateway())
//    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val urlRequest = UrlRequest("https://www.google.com", "id")
        controller = controllerFactory.create(urlRequest)

        viewHolder = ViewHolder(this)
        setContentView(viewHolder?.rootView())
        viewHolder?.bind(controller.getViewData(),controller)
        controller.setup()
    }
}
