package com.surajrathod.daggerexample.screens.questiondetails

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.widget.TextView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.surajrathod.daggerexample.Constants
import com.surajrathod.daggerexample.MyApplication
import com.surajrathod.daggerexample.R
import com.surajrathod.daggerexample.networking.StackoverflowApi
import com.surajrathod.daggerexample.questions.FetchQuestionsDetailsUseCase
import com.surajrathod.daggerexample.screens.common.ScreensNavigator
import com.surajrathod.daggerexample.screens.common.activities.BaseActivity
import com.surajrathod.daggerexample.screens.common.dialogs.DialogsNavigator
import com.surajrathod.daggerexample.screens.common.dialogs.ServerErrorDialogFragment
import com.surajrathod.daggerexample.screens.common.toolbar.MyToolbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.cancellation.CancellationException

class QuestionDetailsActivity : BaseActivity(), QuestionDetailsViewMvc.Listener {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)


    lateinit var viewMvc: QuestionDetailsViewMvc
    private lateinit var stackoverflowApi: StackoverflowApi

    private lateinit var questionId: String

    lateinit var fetchQuestionsDetailsUseCase: FetchQuestionsDetailsUseCase
    lateinit var dialogsNavigator: DialogsNavigator
    lateinit var screensNavigator: ScreensNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewMvc = QuestionDetailsViewMvc(layoutInflater, null)
        setContentView(viewMvc.rootView)

        // retrieve question ID passed from outside
        questionId = intent.extras!!.getString(EXTRA_QUESTION_ID)!!

        fetchQuestionsDetailsUseCase = compositionRoot.fetchQuestionsDetailsUseCase

        dialogsNavigator = DialogsNavigator(supportFragmentManager)
        screensNavigator = ScreensNavigator(this)
    }

    override fun onStart() {
        super.onStart()
        viewMvc.registerListener(this)
        fetchQuestionDetails()
    }

    override fun onStop() {
        super.onStop()
        viewMvc.unregisterListener(this)
        coroutineScope.coroutineContext.cancelChildren()
    }

    private fun fetchQuestionDetails() {
        coroutineScope.launch {
            viewMvc.showProgressIndication()
            try {
                val result = fetchQuestionsDetailsUseCase.fetchQuestionsDetails(questionId)
                when (result) {
                    is FetchQuestionsDetailsUseCase.Result.Success -> {
                        viewMvc.bindQuestionBody(result.questionBody)
                    }

                    is FetchQuestionsDetailsUseCase.Result.Failure -> {
                        onFetchFailed()
                    }
                }
            } finally {
                viewMvc.hideProgressIndication()
            }
        }
    }

    private fun onFetchFailed() {
        dialogsNavigator.showServerErrorDialog()
    }


    companion object {
        const val EXTRA_QUESTION_ID = "EXTRA_QUESTION_ID"
        fun start(context: Context, questionId: String) {
            val intent = Intent(context, QuestionDetailsActivity::class.java)
            intent.putExtra(EXTRA_QUESTION_ID, questionId)
            context.startActivity(intent)
        }
    }

    override fun onBackClicked() {
        screensNavigator.navigateBack()
    }
}