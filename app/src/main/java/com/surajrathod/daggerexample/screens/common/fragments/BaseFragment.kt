package com.surajrathod.daggerexample.screens.common.fragments

import androidx.fragment.app.Fragment
import com.surajrathod.daggerexample.common.di.presentation.DaggerPresentationComponent
import com.surajrathod.daggerexample.common.di.Injector
import com.surajrathod.daggerexample.common.di.presentation.PresentationModule
import com.surajrathod.daggerexample.screens.common.activities.BaseActivity

open class BaseFragment : Fragment() {

    private val compositionRoot by lazy {
        PresentationModule((requireActivity() as BaseActivity).activityCompositionRoot)
    }

    private val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .presentationModule(PresentationModule((requireActivity() as BaseActivity).activityCompositionRoot)).build()
    }

    protected val injector get() = Injector(presentationComponent)
}