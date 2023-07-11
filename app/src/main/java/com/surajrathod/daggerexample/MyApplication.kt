package com.surajrathod.daggerexample

import android.app.Application
import com.surajrathod.daggerexample.common.composition.AppCompositionRoot
import com.surajrathod.daggerexample.networking.StackoverflowApi
import com.surajrathod.daggerexample.questions.FetchQuestionsDetailsUseCase
import com.surajrathod.daggerexample.questions.FetchQuestionsUseCase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication : Application() {

    public lateinit var appCompositionRoot: AppCompositionRoot

    override fun onCreate() {
        super.onCreate()
        appCompositionRoot = AppCompositionRoot()
    }
}