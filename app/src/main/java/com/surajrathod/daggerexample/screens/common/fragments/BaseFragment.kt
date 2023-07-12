package com.surajrathod.daggerexample.screens.common.fragments

import androidx.fragment.app.Fragment
import com.surajrathod.daggerexample.screens.common.activities.BaseActivity

open class BaseFragment : Fragment() {
    protected val compositionRoot get() = (requireActivity() as BaseActivity).compositionRoot
}