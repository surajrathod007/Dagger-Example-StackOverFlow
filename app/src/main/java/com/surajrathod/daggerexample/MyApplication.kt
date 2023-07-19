package com.surajrathod.daggerexample

import android.app.Application
import com.surajrathod.daggerexample.common.di.app.AppComponent
import com.surajrathod.daggerexample.common.di.app.AppModule
import com.surajrathod.daggerexample.common.di.app.DaggerAppComponent

class MyApplication : Application() {

    //public lateinit var appCompositionRoot: AppCompositionRoot

    val appComponent : AppComponent by lazy {
        DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    override fun onCreate() {
        super.onCreate()
        //appCompositionRoot = AppCompositionRoot(this)
    }
}