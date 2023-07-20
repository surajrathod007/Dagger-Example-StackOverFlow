package com.surajrathod.daggerexample.screens.common.viewsMvc

import android.view.LayoutInflater
import android.view.ViewGroup
import com.surajrathod.daggerexample.screens.common.imageloader.ImageLoader
import com.surajrathod.daggerexample.screens.questiondetails.QuestionDetailsViewMvc
import com.surajrathod.daggerexample.screens.questionslist.QuestionsListMvc
import javax.inject.Inject
import javax.inject.Provider

class ViewMvcFactory @Inject constructor(private val layoutInflater: LayoutInflater,private val imageLoaderProvider: Provider<ImageLoader>) {

    fun newQuestionsListMvc(parent: ViewGroup?): QuestionsListMvc {
        return QuestionsListMvc(layoutInflater, parent)
    }

    fun newQuestionDetailsMvc(parent: ViewGroup?) : QuestionDetailsViewMvc{
        return QuestionDetailsViewMvc(layoutInflater,imageLoaderProvider.get(),parent)
    }

}