package com.surajrathod.daggerexample.common.di.app

import android.app.Application
import com.surajrathod.daggerexample.Constants
import com.surajrathod.daggerexample.networking.StackoverflowApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule(val application: Application) {


    @Provides
    @AppScope
    fun retrofit() : Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    @Provides
    fun application() = application

    @AppScope
    @Provides
    fun stackOverFlowApi(retrofit: Retrofit) = retrofit.create(StackoverflowApi::class.java)
}