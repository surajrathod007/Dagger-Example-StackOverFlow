package com.surajrathod.daggerexample.common.di.app

import android.app.Application
import com.surajrathod.daggerexample.Constants
import com.surajrathod.daggerexample.common.di.Retrofit1
import com.surajrathod.daggerexample.common.di.Retrofit2
import com.surajrathod.daggerexample.networking.StackoverflowApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule{


    @Provides
    @Singleton
    @Retrofit1
    fun retrofit1() : Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //it is just sake of example of dagger qualifiers ;)
    @Provides
    @Singleton
    @Retrofit2
    fun retrofit2() : Retrofit = Retrofit.Builder()
        .baseUrl("Some other url")
        .addConverterFactory(GsonConverterFactory.create())
        .build()



    @Singleton
    @Provides
    fun stackOverFlowApi(@Retrofit1 retrofit1: Retrofit) = retrofit1.create(StackoverflowApi::class.java)
}