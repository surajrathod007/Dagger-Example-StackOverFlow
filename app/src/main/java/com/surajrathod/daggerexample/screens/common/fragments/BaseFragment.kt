package com.surajrathod.daggerexample.screens.common.fragments

import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {

    private val presentationComponent by lazy {

    }

    protected val injector get() = presentationComponent
}