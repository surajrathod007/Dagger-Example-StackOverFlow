package com.surajrathod.daggerexample.common.di

import android.view.LayoutInflater
import androidx.fragment.app.FragmentManager
import com.surajrathod.daggerexample.networking.StackoverflowApi
import com.surajrathod.daggerexample.questions.FetchQuestionsDetailsUseCase
import com.surajrathod.daggerexample.questions.FetchQuestionsUseCase
import com.surajrathod.daggerexample.screens.common.dialogs.DialogsNavigator
import com.surajrathod.daggerexample.screens.common.viewsMvc.ViewMvcFactory
import dagger.Module
import dagger.Provides

@Module
class PresentationModule(private val activityCompositionRoot: ActivityComponent) {


    @Provides
    fun layoutInflater() = activityCompositionRoot.layoutInflater()
    @Provides
    fun fragmentManager() = activityCompositionRoot.fragmentManager()
    @Provides
    fun stackOverFlowApi() = activityCompositionRoot.stackoverflowApi()

    @Provides
    fun screensNavigator() = activityCompositionRoot.screensNavigator()
    @Provides
    fun viewMvcFactory(layoutInflater: LayoutInflater) = ViewMvcFactory(layoutInflater)


    @Provides
    fun dialogsNavigator(fragmentManager: FragmentManager) = DialogsNavigator(fragmentManager)

    @Provides
    fun fetchQuestionsUseCase(stackoverflowApi: StackoverflowApi) = FetchQuestionsUseCase(stackoverflowApi)

    @Provides
    fun fetchQuestionsDetailsUseCase(stackoverflowApi: StackoverflowApi) = FetchQuestionsDetailsUseCase(stackoverflowApi)


}