package com.surajrathod.daggerexample

import android.app.Application
import com.surajrathod.daggerexample.common.di.AppCompositionRoot

class MyApplication : Application() {

    public lateinit var appCompositionRoot: AppCompositionRoot

    override fun onCreate() {
        super.onCreate()
        appCompositionRoot = AppCompositionRoot(this)
    }
}