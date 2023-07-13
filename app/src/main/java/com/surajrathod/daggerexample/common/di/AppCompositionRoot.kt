package com.surajrathod.daggerexample.common.di

import android.app.Application
import androidx.annotation.UiThread
import com.surajrathod.daggerexample.Constants
import com.surajrathod.daggerexample.networking.StackoverflowApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@UiThread                   //all the properties in this class will be accessed from the ui thread
class AppCompositionRoot(val application: Application) {


    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val stackoverflowApi by lazy {
        retrofit.create(StackoverflowApi::class.java)
    }

}