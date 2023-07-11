package com.surajrathod.daggerexample.common.composition

import android.app.Activity
import androidx.annotation.UiThread
import com.surajrathod.daggerexample.Constants
import com.surajrathod.daggerexample.networking.StackoverflowApi
import com.surajrathod.daggerexample.questions.FetchQuestionsDetailsUseCase
import com.surajrathod.daggerexample.questions.FetchQuestionsUseCase
import com.surajrathod.daggerexample.screens.common.ScreensNavigator
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@UiThread                   //all the properties in this class will be accessed from the ui thread
class AppCompositionRoot {


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