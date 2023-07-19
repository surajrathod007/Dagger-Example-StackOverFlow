package com.surajrathod.daggerexample.screens.common

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.surajrathod.daggerexample.common.di.activity.ActivityScope
import com.surajrathod.daggerexample.screens.questiondetails.QuestionDetailsActivity
import javax.inject.Inject


class ScreensNavigator(private val activity : AppCompatActivity) {

    fun toQuestionDetails(questionId : String){
        QuestionDetailsActivity.start(activity,questionId)
    }

    fun navigateBack(){
        activity.onBackPressed()
    }

}