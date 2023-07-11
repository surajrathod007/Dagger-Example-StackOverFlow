package com.surajrathod.daggerexample.common.composition

import android.app.Activity
import androidx.fragment.app.FragmentManager
import com.surajrathod.daggerexample.questions.FetchQuestionsDetailsUseCase
import com.surajrathod.daggerexample.questions.FetchQuestionsUseCase
import com.surajrathod.daggerexample.screens.common.ScreensNavigator

class ActivityCompositionRoot(
    private val activity: Activity,
    private val appCompositionRoot: AppCompositionRoot,
) {

    val screensNavigator : ScreensNavigator by lazy {
        ScreensNavigator(activity)
    }


    private val stackoverflowApi get() = appCompositionRoot.stackoverflowApi
    val fetchQuestionsUseCase get() = FetchQuestionsUseCase(stackoverflowApi)
    // get() means every time this property acceesd it will create new instance of fetchQuestionsUseCase

    val fetchQuestionsDetailsUseCase get() = FetchQuestionsDetailsUseCase(stackoverflowApi)


}