package com.example.urltestapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.example.controller.Controller
import com.example.urltestapp.databinding.ActivityMainBinding
import com.jakewharton.rxbinding3.view.clicks
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

class ViewHolder(context: Context) {

    private val viewBinding = ActivityMainBinding.inflate(LayoutInflater.from(context))
    private var disposables = CompositeDisposable()

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
        viewBinding.fetchButton
            .clicks()
            .debounce(100, TimeUnit.MILLISECONDS)
            .fetchUrlAction(controller)
            .disposeBy(disposables)
    }

    private fun bindResetButton(controller: Controller) {
        viewBinding.resetButton
            .clicks()
            .debounce(100, TimeUnit.MILLISECONDS)
            .resetAction(controller)
            .disposeBy(disposables)
    }


    fun unbind() {
        viewBinding.data = null;
        disposables.dispose()
        disposables = CompositeDisposable()
    }

}

private fun Observable<Unit>.fetchUrlAction(controller: Controller): Disposable {
    return controller.bindFetchUrlActionTo(this)
}

private fun Observable<Unit>.resetAction(controller: Controller): Disposable {
    return controller.bindResetActionTo(this)
}

private fun Disposable.disposeBy(disposables: CompositeDisposable) {
    disposables.add(this)
}
