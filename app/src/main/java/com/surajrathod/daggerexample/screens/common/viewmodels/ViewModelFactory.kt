package com.surajrathod.daggerexample.screens.common.viewmodels

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import com.surajrathod.daggerexample.questions.FetchQuestionsDetailsUseCase
import com.surajrathod.daggerexample.questions.FetchQuestionsUseCase
import com.surajrathod.daggerexample.screens.viewmodel.MyViewModel
import com.surajrathod.daggerexample.screens.viewmodel.MyViewModel2
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    private val fetchQuestionsDetailsUseCaseProvider: Provider<FetchQuestionsDetailsUseCase>,
    private val fetchQuestionsUseCaseProvider: Provider<FetchQuestionsUseCase>,
    savedStateRegistryOwner: SavedStateRegistryOwner
) :
    AbstractSavedStateViewModelFactory(savedStateRegistryOwner, null) {

    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return when (modelClass) {
            MyViewModel::class.java -> MyViewModel(
                fetchQuestionsUseCaseProvider.get(),
                fetchQuestionsDetailsUseCaseProvider.get(),
                handle
            ) as T

            MyViewModel2::class.java -> MyViewModel2(
                fetchQuestionsUseCaseProvider.get()
            ) as T

            else -> throw RuntimeException("Unsupported viewmodel $modelClass")
        }
    }
}