package com.surajrathod.daggerexample.screens.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.surajrathod.daggerexample.questions.FetchQuestionsUseCase
import com.surajrathod.daggerexample.questions.Question
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class MyViewModel2 @Inject constructor(private val fetchQuestionsUseCase: FetchQuestionsUseCase) :
    ViewModel() {


    private val _questions = MutableLiveData<List<Question>>()
    val questions: LiveData<List<Question>> = _questions

    init {
        viewModelScope.launch {
            val r = fetchQuestionsUseCase.fetchQuestions()
            if (r is FetchQuestionsUseCase.Result.Success) {
                _questions.value = r.questions
            }
        }
    }

}