package com.surajrathod.daggerexample.common.di

import android.app.Application
import com.surajrathod.daggerexample.networking.StackoverflowApi
import dagger.Component
import dagger.Provides

@Component(modules = [AppModule::class])
interface AppComponent {


    fun application() : Application


    fun stackOverFlowApi() : StackoverflowApi

}