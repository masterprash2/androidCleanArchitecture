package com.example.urltestapp

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {


    lateinit var viewHolder: ViewHolder

    @Inject
    lateinit var controllerFactory: ControlleFactory

    lateinit var controller : Controller

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initController()
        initView()
    }

    private fun initController() {
        val urlRequest = UrlRequest("https://www.google.com", "id")
        controller = controllerFactory.create(urlRequest)
        controller.setup()
    }

    private fun initView() {
        viewHolder = ViewHolder(this)
        viewHolder.bind(controller)
        setContentView(viewHolder.rootView())
    }
}
