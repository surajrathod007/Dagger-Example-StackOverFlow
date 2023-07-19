package com.surajrathod.daggerexample.common.di.app

import android.app.Application
import com.surajrathod.daggerexample.common.di.activity.ActivityComponent
import com.surajrathod.daggerexample.common.di.activity.ActivityModule
import com.surajrathod.daggerexample.networking.StackoverflowApi
import dagger.Component
import javax.inject.Singleton

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {

    fun newActivityComponent(activityModule: ActivityModule) : ActivityComponent
//
//    fun application() : Application
//
//
//    fun stackOverFlowApi() : StackoverflowApi

}