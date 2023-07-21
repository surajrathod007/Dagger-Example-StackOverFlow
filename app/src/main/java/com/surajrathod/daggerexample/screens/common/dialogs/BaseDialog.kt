package com.surajrathod.daggerexample.screens.common.dialogs

import androidx.fragment.app.DialogFragment
import com.surajrathod.daggerexample.common.di.presentation.PresentationModule
import com.surajrathod.daggerexample.screens.common.activities.BaseActivity

open class BaseDialog : DialogFragment() {

    private val presentationComponent by lazy {

    }

    protected val injector get() = presentationComponent
}