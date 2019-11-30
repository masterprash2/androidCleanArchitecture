package com.example.urltestapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.example.urltestapp.databinding.ActivityMainBinding
import com.jakewharton.rxbinding3.view.clicks
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

class ViewHolder(context: Context) {

    private val viewBinding: ActivityMainBinding
    private var viewData: ViewData? = null
    private var controller: Controller? = null
    private var disposables = CompositeDisposable()

    init {
        viewBinding = ActivityMainBinding.inflate(LayoutInflater.from(context))
    }

    fun rootView(): View {
        return viewBinding.root
    }

    fun bind(viewData: ViewData, controller: Controller) {
        this.viewData = viewData
        this.controller = controller
        viewBinding.viewHolder = this
        viewBinding.data = viewData

        disposables.add(
            controller.bindFetchUrlActionTo(
                viewBinding.fetchButton.clicks().debounce(100, TimeUnit.MILLISECONDS)
            )
        )

        disposables.add(
            controller.bindResetButton(
                viewBinding.resetButton.clicks().debounce(
                    100,
                    TimeUnit.MILLISECONDS
                )
            )
        )
    }


    fun unbind() {
        controller = null;
        viewData = null
        viewBinding.data = null;
        disposables.dispose()
        disposables = CompositeDisposable()
    }


}