package com.surajrathod.daggerexample.common.di.presentation

import com.surajrathod.daggerexample.screens.questiondetails.QuestionDetailsActivity
import com.surajrathod.daggerexample.screens.questionslist.QuestionsListActivity
import com.surajrathod.daggerexample.screens.questionslist.QuestionsListFragment
import dagger.Subcomponent

@PresentationScope
@Subcomponent()
interface PresentationComponent {
    fun inject(fragment: QuestionsListFragment)
    fun inject(questionDetailsActivity: QuestionDetailsActivity)
    fun inject(questionsListActivity: QuestionsListActivity) {

    }

}