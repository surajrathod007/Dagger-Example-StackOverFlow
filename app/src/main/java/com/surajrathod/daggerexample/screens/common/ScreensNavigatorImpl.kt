package com.surajrathod.daggerexample.screens.common

import androidx.appcompat.app.AppCompatActivity
import com.surajrathod.daggerexample.screens.questiondetails.QuestionDetailsActivity


class ScreensNavigatorImpl(private val activity : AppCompatActivity) : ScreensNavigator{

    override fun toQuestionDetails(questionId : String){
        QuestionDetailsActivity.start(activity,questionId)
    }

    override fun navigateBack(){
        activity.onBackPressed()
    }

}