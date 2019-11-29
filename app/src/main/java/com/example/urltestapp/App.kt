package com.example.urltestapp

import android.app.Application
import com.example.urltestapp.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject

class App : DaggerApplication() {

    lateinit var injector: AndroidInjector<App>

    override fun applicationInjector(): AndroidInjector<App> {
        return injector
    }

    override fun onCreate() {
        this.injector = DaggerAppComponent.factory().create(this)
        super.onCreate()
    }

}