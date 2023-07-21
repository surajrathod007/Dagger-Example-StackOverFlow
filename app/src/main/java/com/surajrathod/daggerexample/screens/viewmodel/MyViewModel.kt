package com.surajrathod.daggerexample.screens.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.surajrathod.daggerexample.questions.FetchQuestionsDetailsUseCase
import com.surajrathod.daggerexample.questions.FetchQuestionsUseCase
import com.surajrathod.daggerexample.questions.Question
import com.surajrathod.daggerexample.screens.common.viewmodels.SavedStateViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class MyViewModel @Inject constructor(private val fetchQuestionsUseCase: FetchQuestionsUseCase,
private val fetchQuestionsDetailsUseCase: FetchQuestionsDetailsUseCase) : SavedStateViewModel() {

    private lateinit var _questions : MutableLiveData<List<Question>>
    val questions : LiveData<List<Question>> get()  = _questions

    override fun init(savedStateHandle: SavedStateHandle) {
        _questions = savedStateHandle.getLiveData("questions")
        viewModelScope.launch {
            val r = fetchQuestionsUseCase.fetchQuestions()
            if(r is FetchQuestionsUseCase.Result.Success){
                _questions.value = r.questions
            }
        }
    }
}