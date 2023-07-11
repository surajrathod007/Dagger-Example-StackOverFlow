package com.surajrathod.daggerexample

import android.app.Application
import com.surajrathod.daggerexample.networking.StackoverflowApi
import com.surajrathod.daggerexample.questions.FetchQuestionsDetailsUseCase
import com.surajrathod.daggerexample.questions.FetchQuestionsUseCase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication : Application() {

    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    public val stackoverflowApi = retrofit.create(StackoverflowApi::class.java)
    public val fetchQuestionsUseCase get()  = FetchQuestionsUseCase(stackoverflowApi)
    // get() means every time this property acceesd it will create new instance of fetchQuestionsUseCase

    public val fetchQuestionsDetailsUseCase get() = FetchQuestionsDetailsUseCase(stackoverflowApi)

    override fun onCreate() {
        super.onCreate()
    }
}