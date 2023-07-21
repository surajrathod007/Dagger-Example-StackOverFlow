package com.surajrathod.daggerexample

import android.app.Application
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class MyApplication : Application() {

    //public lateinit var appCompositionRoot: AppCompositionRoot

    override fun onCreate() {
        super.onCreate()
        //appCompositionRoot = AppCompositionRoot(this)
    }
}