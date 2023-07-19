package com.surajrathod.daggerexample.screens.common.fragments

import androidx.fragment.app.Fragment
import com.surajrathod.daggerexample.common.di.presentation.PresentationModule
import com.surajrathod.daggerexample.common.di.presentation.UseCasesModule
import com.surajrathod.daggerexample.screens.common.activities.BaseActivity

open class BaseFragment : Fragment() {

    private val presentationComponent by lazy {
        (requireActivity() as BaseActivity).activityCompositionRoot.newPresentationComponent(PresentationModule(),
            UseCasesModule()
        )
    }

    protected val injector get() = presentationComponent
}