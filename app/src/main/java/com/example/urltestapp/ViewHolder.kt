package com.example.urltestapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.example.urltestapp.databinding.ActivityMainBinding

class ViewHolder(context: Context) {

    private val viewBinding : ActivityMainBinding
    private var viewData : ViewData? = null
    private var controller : Controller? = null

    init {
        viewBinding = ActivityMainBinding.inflate(LayoutInflater.from(context))
    }


    fun rootView() : View {
        return viewBinding.root
    }

    fun bind(viewData: ViewData, controller: Controller) {
        this.viewData = viewData
        this.controller = controller
        viewBinding.viewHolder = this
        viewBinding.data = viewData
    }


    fun fetchButtonClicked() {
        controller?.fetchUrlData()
    }


}