package com.surajrathod.daggerexample.common.di

import com.surajrathod.daggerexample.screens.common.fragments.BaseFragment
import com.surajrathod.daggerexample.screens.questiondetails.QuestionDetailsActivity
import com.surajrathod.daggerexample.screens.questionslist.QuestionsListFragment

class Injector(private val presentationCompositionRoot: PresentationCompositionRoot) {

    fun inject(fragment : QuestionsListFragment) {
        fragment.dialogsNavigator = presentationCompositionRoot.dialogsNavigator
        fragment.fetchQuestionsUseCase = presentationCompositionRoot.fetchQuestionsUseCase
        fragment.screensNavigator = presentationCompositionRoot.screensNavigator
        fragment.viewMvcFactory = presentationCompositionRoot.viewMvcFactory
    }

    fun inject(activity: QuestionDetailsActivity) {
        activity.screensNavigator = presentationCompositionRoot.screensNavigator
        activity.fetchQuestionsDetailsUseCase = presentationCompositionRoot.fetchQuestionsDetailsUseCase
        activity.dialogsNavigator = presentationCompositionRoot.dialogsNavigator
        activity.viewMvcFactory = presentationCompositionRoot.viewMvcFactory
    }

}