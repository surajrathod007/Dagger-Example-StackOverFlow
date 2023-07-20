package com.surajrathod.daggerexample.screens.common.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.surajrathod.daggerexample.screens.viewmodel.MyViewModel
import com.surajrathod.daggerexample.screens.viewmodel.MyViewModel2
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(private val viewModelProvider: Provider<MyViewModel>,
private val myViewModel2Provider : Provider<MyViewModel2>) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when(modelClass){
            MyViewModel::class.java -> viewModelProvider.get() as T
            MyViewModel2::class.java -> myViewModel2Provider.get() as T
            else -> throw RuntimeException("Unsupported Viewmodel")
        }
    }
}