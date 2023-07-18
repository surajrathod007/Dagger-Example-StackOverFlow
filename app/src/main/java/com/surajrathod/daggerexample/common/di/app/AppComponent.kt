package com.surajrathod.daggerexample.common.di.app

import android.app.Application
import com.surajrathod.daggerexample.networking.StackoverflowApi
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {


    fun application() : Application


    fun stackOverFlowApi() : StackoverflowApi

}