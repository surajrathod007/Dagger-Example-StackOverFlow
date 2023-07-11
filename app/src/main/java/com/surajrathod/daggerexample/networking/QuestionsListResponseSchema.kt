package com.surajrathod.daggerexample.networking

import com.google.gson.annotations.SerializedName
import com.surajrathod.daggerexample.questions.Question

class QuestionsListResponseSchema(@SerializedName("items") val questions: List<Question>)