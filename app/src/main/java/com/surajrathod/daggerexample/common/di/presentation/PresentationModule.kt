package com.surajrathod.daggerexample.common.di.presentation

import android.view.LayoutInflater
import androidx.fragment.app.FragmentManager
import com.surajrathod.daggerexample.common.di.activity.ActivityComponent
import com.surajrathod.daggerexample.networking.StackoverflowApi
import com.surajrathod.daggerexample.questions.FetchQuestionsDetailsUseCase
import com.surajrathod.daggerexample.questions.FetchQuestionsUseCase
import com.surajrathod.daggerexample.screens.common.dialogs.DialogsNavigator
import com.surajrathod.daggerexample.screens.common.viewsMvc.ViewMvcFactory
import dagger.Module
import dagger.Provides

@Module
class PresentationModule() {

    @Provides
    fun viewMvcFactory(layoutInflater: LayoutInflater) = ViewMvcFactory(layoutInflater)


    @Provides
    fun dialogsNavigator(fragmentManager: FragmentManager) = DialogsNavigator(fragmentManager)


}