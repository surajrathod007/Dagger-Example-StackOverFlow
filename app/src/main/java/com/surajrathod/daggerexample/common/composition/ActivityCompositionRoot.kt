package com.surajrathod.daggerexample.common.composition

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.surajrathod.daggerexample.questions.FetchQuestionsDetailsUseCase
import com.surajrathod.daggerexample.questions.FetchQuestionsUseCase
import com.surajrathod.daggerexample.screens.common.ScreensNavigator
import com.surajrathod.daggerexample.screens.common.dialogs.DialogsNavigator

class ActivityCompositionRoot(
    private val activity: AppCompatActivity,
    private val appCompositionRoot: AppCompositionRoot,
) {

    val screensNavigator : ScreensNavigator by lazy {
        ScreensNavigator(activity)
    }


    private val fragmentManager get() = activity.supportFragmentManager

    val dialogsNavigator get() = DialogsNavigator(fragmentManager)

    private val stackoverflowApi get() = appCompositionRoot.stackoverflowApi
    val fetchQuestionsUseCase get() = FetchQuestionsUseCase(stackoverflowApi)
    // get() means every time this property acceesd it will create new instance of fetchQuestionsUseCase

    val fetchQuestionsDetailsUseCase get() = FetchQuestionsDetailsUseCase(stackoverflowApi)


}