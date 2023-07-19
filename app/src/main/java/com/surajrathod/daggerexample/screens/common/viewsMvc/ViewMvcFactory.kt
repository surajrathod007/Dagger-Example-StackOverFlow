package com.surajrathod.daggerexample.screens.common.viewsMvc

import android.view.LayoutInflater
import android.view.ViewGroup
import com.surajrathod.daggerexample.screens.questiondetails.QuestionDetailsViewMvc
import com.surajrathod.daggerexample.screens.questionslist.QuestionsListMvc
import javax.inject.Inject

class ViewMvcFactory @Inject constructor(private val layoutInflater: LayoutInflater) {

    fun newQuestionsListMvc(parent: ViewGroup?): QuestionsListMvc {
        return QuestionsListMvc(layoutInflater, parent)
    }

    fun newQuestionDetailsMvc(parent: ViewGroup?) : QuestionDetailsViewMvc{
        return QuestionDetailsViewMvc(layoutInflater,parent)
    }

}