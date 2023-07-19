package com.surajrathod.daggerexample.common.di.app

import android.app.Application
import com.surajrathod.daggerexample.common.di.activity.ActivityComponent
import com.surajrathod.daggerexample.common.di.activity.ActivityModule
import com.surajrathod.daggerexample.common.di.service.ServiceComponent
import com.surajrathod.daggerexample.common.di.service.ServiceModule
import com.surajrathod.daggerexample.networking.StackoverflowApi
import dagger.Component
import javax.inject.Singleton

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {

    fun newActivityComponent(activityModule: ActivityModule) : ActivityComponent

    fun newServiceComponent(serviceModule: ServiceModule) : ServiceComponent
//
//    fun application() : Application
//
//
//    fun stackOverFlowApi() : StackoverflowApi

}