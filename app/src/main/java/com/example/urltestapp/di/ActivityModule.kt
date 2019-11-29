package com.example.urltestapp.di

import com.example.urltestapp.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule  {

    @ContributesAndroidInjector
    abstract fun mainActivity() : MainActivity

}