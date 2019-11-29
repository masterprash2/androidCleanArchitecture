package com.example.urltestapp.di

import com.example.urltestapp.App
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@AppScope
@Component(
    modules = [AndroidSupportInjectionModule::class,
        AndroidInjectionModule::class, AppModule::class,
        ActivityModule::class]
)
interface AppComponent : AndroidInjector<App> {


    @Component.Factory
    interface Factory : AndroidInjector.Factory<App> {

    }
}