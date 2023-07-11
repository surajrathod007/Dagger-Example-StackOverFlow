package com.surajrathod.daggerexample.networking

import com.google.gson.annotations.SerializedName
import com.surajrathod.daggerexample.questions.QuestionWithBody

data class SingleQuestionResponseSchema(@SerializedName("items") val questions: List<QuestionWithBody>) {
    val question: QuestionWithBody get() = questions[0]
}