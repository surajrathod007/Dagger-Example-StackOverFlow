package com.surajrathod.daggerexample.screens.common

import com.surajrathod.daggerexample.screens.questiondetails.QuestionDetailsActivity

interface ScreensNavigator {

    fun toQuestionDetails(questionId : String)

    fun navigateBack()
}