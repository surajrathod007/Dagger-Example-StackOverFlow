package com.surajrathod.daggerexample.screens.common.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.surajrathod.daggerexample.screens.viewmodel.MyViewModel
import com.surajrathod.daggerexample.screens.viewmodel.MyViewModel2
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(private val providers: Map<Class<out ViewModel>,@JvmSuppressWildcards Provider<ViewModel>>) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val providers = providers[modelClass]
        return providers?.get() as T ?: throw RuntimeException("Unsupported Viewmodel")

    }
}