package com.surajrathod.daggerexample.common.service

import android.app.Service
import com.surajrathod.daggerexample.MyApplication
import com.surajrathod.daggerexample.common.di.activity.ActivityModule
import com.surajrathod.daggerexample.common.di.app.AppComponent
import com.surajrathod.daggerexample.common.di.service.ServiceModule

abstract class BaseService : Service() {

    private val appComponent: AppComponent get() = (application as MyApplication).appComponent

    val serviceComponent by lazy {
        appComponent.newServiceComponent(ServiceModule(this))
    }

}