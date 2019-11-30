package com.example.urltestapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.example.controller.Controller
import com.example.urltestapp.databinding.ActivityMainBinding
import com.jakewharton.rxbinding3.view.clicks
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

class ViewHolder(context: Context) {

    private val viewBinding: ActivityMainBinding
    private var disposables = CompositeDisposable()

    init {
        viewBinding = ActivityMainBinding.inflate(LayoutInflater.from(context))
    }

    fun rootView(): View {
        return viewBinding.root
    }

    fun bind(controller: Controller) {
        viewBinding.viewHolder = this
        viewBinding.data = controller.getViewData()

        bindFetchButton(controller)
        bindResetButton(controller)
    }

    private fun bindFetchButton(controller: Controller) {
        disposables.add(
            controller.bindFetchUrlActionTo(
                viewBinding.fetchButton.clicks().debounce(100, TimeUnit.MILLISECONDS)
            )
        )
    }

    private fun bindResetButton(controller: Controller) {
        disposables.add(
            controller.bindResetActionTo(
                viewBinding.resetButton.clicks().debounce(100, TimeUnit.MILLISECONDS)
            )
        )
    }


    fun unbind() {
        viewBinding.data = null;
        disposables.dispose()
        disposables = CompositeDisposable()
    }


}