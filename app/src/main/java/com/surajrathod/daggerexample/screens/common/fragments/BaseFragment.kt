package com.surajrathod.daggerexample.screens.common.fragments

import androidx.fragment.app.Fragment
import com.surajrathod.daggerexample.common.di.presentation.DaggerPresentationComponent
import com.surajrathod.daggerexample.common.di.presentation.PresentationModule
import com.surajrathod.daggerexample.screens.common.activities.BaseActivity

open class BaseFragment : Fragment() {

    private val presentationComponent by lazy {
        DaggerPresentationComponent.builder().activityComponent((requireActivity() as BaseActivity).activityCompositionRoot)
            .presentationModule(PresentationModule()).build()
    }

    protected val injector get() = presentationComponent
}