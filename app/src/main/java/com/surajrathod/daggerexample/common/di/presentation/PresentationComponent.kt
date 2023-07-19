package com.surajrathod.daggerexample.common.di.presentation

import com.surajrathod.daggerexample.common.di.activity.ActivityComponent
import com.surajrathod.daggerexample.questions.FetchQuestionsDetailsUseCase
import com.surajrathod.daggerexample.questions.FetchQuestionsUseCase
import com.surajrathod.daggerexample.screens.common.ScreensNavigator
import com.surajrathod.daggerexample.screens.common.dialogs.DialogsNavigator
import com.surajrathod.daggerexample.screens.common.viewsMvc.ViewMvcFactory
import com.surajrathod.daggerexample.screens.questiondetails.QuestionDetailsActivity
import com.surajrathod.daggerexample.screens.questionslist.QuestionsListFragment
import dagger.Component
import dagger.Subcomponent

@PresentationScope
@Subcomponent(modules = [PresentationModule::class])
interface PresentationComponent {
    fun inject(fragment: QuestionsListFragment)
    fun inject(questionDetailsActivity: QuestionDetailsActivity)

}