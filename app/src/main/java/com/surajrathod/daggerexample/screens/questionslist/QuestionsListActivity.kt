package com.surajrathod.daggerexample.screens.questionslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.surajrathod.daggerexample.Constants
import com.surajrathod.daggerexample.R
import com.surajrathod.daggerexample.networking.StackoverflowApi
import com.surajrathod.daggerexample.questions.Question
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

class QuestionsListActivity : AppCompatActivity() ,QuestionsListMvc.Listener {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)


    private lateinit var stackoverflowApi: StackoverflowApi
    private lateinit var toolbar : MyToolbar

    private var isDataLoaded = false

    private lateinit var viewMvc : QuestionsListMvc

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        viewMvc = QuestionsListMvc(LayoutInflater.from(this),null)


        setContentView(viewMvc.rootView)

        // init retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        stackoverflowApi = retrofit.create(StackoverflowApi::class.java)
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
                val response = stackoverflowApi.lastActiveQuestions(20)
                if (response.isSuccessful && response.body() != null) {
                    //questionsAdapter.bindData(response.body()!!.questions)
                    viewMvc.bindQuestions(response.body()!!.questions)
                    isDataLoaded = true
                } else {
                    onFetchFailed()
                }
            } catch (t: Throwable) {
                if (t !is CancellationException) {
                    onFetchFailed()
                }
            } finally {
                viewMvc.hideProgressIndication()
            }
        }
    }

    private fun onFetchFailed() {
        supportFragmentManager.beginTransaction()
            .add(ServerErrorDialogFragment.newInstance(), null)
            .commitAllowingStateLoss()
    }



    override fun onRefreshClicked() {
        fetchQuestions()
    }

    override fun onQuestionClicked(clickedQuestion: Question) {
        QuestionDetailsActivity.start(this,clickedQuestion.id)
    }


}