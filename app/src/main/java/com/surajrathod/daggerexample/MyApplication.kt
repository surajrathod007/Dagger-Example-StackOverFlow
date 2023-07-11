package com.surajrathod.daggerexample

import android.app.Application
import com.surajrathod.daggerexample.networking.StackoverflowApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication : Application() {

    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    public val stackoverflowApi = retrofit.create(StackoverflowApi::class.java)

    override fun onCreate() {
        super.onCreate()
    }
}