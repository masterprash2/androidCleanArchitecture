package com.example.viewdata

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import javax.inject.Inject

class ViewData @Inject constructor() {

    val showFetchButton = ObservableBoolean()
    val showResetButton = ObservableBoolean()
    val message = ObservableField<String>()
    val showProgress = ObservableBoolean()


    fun defaultState() {
        showFetchButton.set(true)
        showResetButton.set(false)
        showProgress.set(false)
        message.set("")
    }


    fun showLoading() {
        showProgress.set(true)
        message.set("")
        showResetButton.set(false)
        showFetchButton.set(false)
    }

    fun showSuccess() {
        showProgress.set(false)
        message.set("Data Loaded")
        showResetButton.set(true)
        showFetchButton.set(false)
    }

    fun showNetworkFailure() {
        showProgress.set(false)
        message.set("Network Error")
        showResetButton.set(true)
        showFetchButton.set(false)
    }

    fun showConnectionError() {
        showProgress.set(false)
        message.set("Connenction Not Available")
        showResetButton.set(true)
        showFetchButton.set(false)
    }


}