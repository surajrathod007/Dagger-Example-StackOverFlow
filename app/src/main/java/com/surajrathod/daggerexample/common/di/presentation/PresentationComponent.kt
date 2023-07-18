package com.surajrathod.daggerexample.common.di.presentation

import com.surajrathod.daggerexample.questions.FetchQuestionsDetailsUseCase
import com.surajrathod.daggerexample.questions.FetchQuestionsUseCase
import com.surajrathod.daggerexample.screens.common.ScreensNavigator
import com.surajrathod.daggerexample.screens.common.dialogs.DialogsNavigator
import com.surajrathod.daggerexample.screens.common.viewsMvc.ViewMvcFactory
import dagger.Component

@Component(modules = [PresentationModule::class])
interface PresentationComponent {

    fun screensNavigator() : ScreensNavigator

    fun viewMvcFactory() : ViewMvcFactory

    fun dialogsNavigator() : DialogsNavigator

    fun fetchQuestionsUseCase() : FetchQuestionsUseCase

    fun fetchQuestionsDetailsUseCase() : FetchQuestionsDetailsUseCase

}