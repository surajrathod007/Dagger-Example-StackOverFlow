package com.surajrathod.daggerexample.screens.common

import androidx.appcompat.app.AppCompatActivity
import com.surajrathod.daggerexample.common.di.activity.ActivityScope
import com.surajrathod.daggerexample.screens.questiondetails.QuestionDetailsActivity
import com.surajrathod.daggerexample.screens.viewmodel.ViewModelActivity
import javax.inject.Inject



class ScreensNavigatorImpl @Inject constructor(private val activity : AppCompatActivity) : ScreensNavigator{

    override fun toQuestionDetails(questionId : String){
        QuestionDetailsActivity.start(activity,questionId)
    }

    override fun navigateBack(){
        activity.onBackPressed()
    }

    override fun toViewModel() {
        ViewModelActivity.start(activity)
    }

}