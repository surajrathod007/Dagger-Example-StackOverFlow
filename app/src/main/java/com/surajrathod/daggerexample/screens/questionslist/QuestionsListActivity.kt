package com.surajrathod.daggerexample.screens.questionslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.surajrathod.daggerexample.Constants
import com.surajrathod.daggerexample.MyApplication
import com.surajrathod.daggerexample.networking.StackoverflowApi
import com.surajrathod.daggerexample.questions.FetchQuestionsUseCase
import com.surajrathod.daggerexample.questions.Question
import com.surajrathod.daggerexample.screens.common.ScreensNavigator
import com.surajrathod.daggerexample.screens.common.activities.BaseActivity
import com.surajrathod.daggerexample.screens.common.dialogs.DialogsNavigator
import com.surajrathod.daggerexample.screens.common.dialogs.ServerErrorDialogFragment
import com.surajrathod.daggerexample.screens.common.toolbar.MyToolbar
import com.surajrathod.daggerexample.screens.questiondetails.QuestionDetailsActivity
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuestionsListActivity : BaseActivity(), QuestionsListMvc.Listener {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    private lateinit var toolbar: MyToolbar
    private var isDataLoaded = false

    private lateinit var viewMvc: QuestionsListMvc

    private lateinit var fetchQuestionsUseCase: FetchQuestionsUseCase
    lateinit var dialogsNavigator: DialogsNavigator
    lateinit var screensNavigator: ScreensNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        viewMvc = QuestionsListMvc(LayoutInflater.from(this), null)


        setContentView(viewMvc.rootView)

        fetchQuestionsUseCase = compositionRoot.fetchQuestionsUseCase
        dialogsNavigator = DialogsNavigator(supportFragmentManager)
        screensNavigator = ScreensNavigator(this)
    }

    override fun onStart() {
        super.onStart()
        viewMvc.registerListener(this)
        if (!isDataLoaded) {
            fetchQuestions()
        }
    }

    override fun onStop() {
        super.onStop()
        coroutineScope.coroutineContext.cancelChildren()
        viewMvc.unregisterListener(this)
    }

    private fun fetchQuestions() {
        coroutineScope.launch {
            viewMvc.showProgressIndication()
            try {
                val result = fetchQuestionsUseCase.fetchQuestions()
                when (result) {
                    is FetchQuestionsUseCase.Result.Success -> {
                        viewMvc.bindQuestions(result.questions)
                        isDataLoaded = true
                    }

                    is FetchQuestionsUseCase.Result.Failure -> {
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

    override fun onRefreshClicked() {
        fetchQuestions()
    }

    override fun onQuestionClicked(clickedQuestion: Question) {
        screensNavigator.toQuestionDetails(clickedQuestion.id)
    }

}