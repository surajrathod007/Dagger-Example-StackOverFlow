package com.surajrathod.daggerexample.screens.common

import android.app.Activity
import android.content.Context
import com.surajrathod.daggerexample.screens.questiondetails.QuestionDetailsActivity

class ScreensNavigator(private val activity : Activity) {

    fun toQuestionDetails(questionId : String){
        QuestionDetailsActivity.start(activity,questionId)
    }

    fun navigateBack(){
        activity.onBackPressed()
    }

}