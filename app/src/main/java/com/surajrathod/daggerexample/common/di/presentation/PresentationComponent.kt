package com.surajrathod.daggerexample.common.di.presentation

import com.surajrathod.daggerexample.screens.questiondetails.QuestionDetailsActivity
import com.surajrathod.daggerexample.screens.questionslist.QuestionsListActivity
import com.surajrathod.daggerexample.screens.questionslist.QuestionsListFragment
import com.surajrathod.daggerexample.screens.viewmodel.ViewModelActivity
import dagger.Subcomponent

@PresentationScope
@Subcomponent(modules = [PresentationModule::class])
interface PresentationComponent {
    fun inject(fragment: QuestionsListFragment)
    fun inject(questionDetailsActivity: QuestionDetailsActivity)
    fun inject(questionsListActivity: QuestionsListActivity)
    fun inject(viewModelActivity: ViewModelActivity)

}