package com.surajrathod.daggerexample.questions

import com.surajrathod.daggerexample.Constants
import com.surajrathod.daggerexample.networking.StackoverflowApi
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class FetchQuestionsDetailsUseCase @Inject constructor(
    private var stackoverflowApi: StackoverflowApi
) {

    sealed class Result {
        data class Success(val questionBody: QuestionWithBody) : Result()
        object Failure : Result()
    }


    suspend fun fetchQuestionsDetails(questionId: String): Result {
        return withContext(Dispatchers.IO) {
            try {
                val response = stackoverflowApi.questionDetails(questionId)
                if (response.isSuccessful && response.body() != null) {
                    val questionBody = response.body()!!.question
                    return@withContext Result.Success(questionBody)
                } else {
                    return@withContext Result.Failure
                }
            } catch (t: Throwable) {
                if (t !is CancellationException) {
                    return@withContext Result.Failure
                } else {
                    throw t
                }
            }
        }
    }
}