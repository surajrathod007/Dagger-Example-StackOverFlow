package com.surajrathod.daggerexample.screens.questionslist

import android.os.Bundle
import com.surajrathod.daggerexample.R
import com.surajrathod.daggerexample.screens.common.activities.BaseActivity

class QuestionsListActivity : BaseActivity() {

//    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
//
//    private lateinit var toolbar: MyToolbar
//    private var isDataLoaded = false
//
//    private lateinit var viewMvc: QuestionsListMvc
//
//    private lateinit var fetchQuestionsUseCase: FetchQuestionsUseCase
//    lateinit var dialogsNavigator: DialogsNavigator
//    lateinit var screensNavigator: ScreensNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.layout_frame)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.frame_content, QuestionsListFragment())
                .commit()
        }

//        viewMvc = QuestionsListMvc(LayoutInflater.from(this), null)
//        setContentView(viewMvc.rootView)
//        fetchQuestionsUseCase = compositionRoot.fetchQuestionsUseCase
//        dialogsNavigator = compositionRoot.dialogsNavigator
//        screensNavigator = compositionRoot.screensNavigator
    }

    /*
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

     */

}