package com.surajrathod.daggerexample.screens.questiondetails

import android.content.Context
import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.surajrathod.daggerexample.R
import com.surajrathod.daggerexample.screens.common.toolbar.MyToolbar
import com.surajrathod.daggerexample.screens.common.viewsMvc.BaseViewMvc

class QuestionDetailsViewMvc(
    private val layoutInflater: LayoutInflater,
    private val parent: ViewGroup?
) : BaseViewMvc<QuestionDetailsViewMvc.Listener>() {

    interface Listener{
        fun onBackClicked()
    }

    private var toolbar: MyToolbar
    private var swipeRefresh: SwipeRefreshLayout
    private var txtQuestionBody: TextView

    val rootView = layoutInflater.inflate(R.layout.layout_question_details, parent, false)
    val context : Context get() = rootView.context


    init {

        txtQuestionBody = findViewById(R.id.txt_question_body)

        // init toolbar
        toolbar = findViewById(R.id.toolbar)
        toolbar.setNavigateUpListener {
            for(listener in listeners){
                listener.onBackClicked()
            }
        }

        // init pull-down-to-refresh (used as a progress indicator)
        swipeRefresh = findViewById(R.id.swipeRefresh)
        swipeRefresh.isEnabled = false


    }

    private fun <T : View?> findViewById(@IdRes id: Int): T {
        return rootView.findViewById<T>(id)
    }

    fun showProgressIndication() {
        swipeRefresh.isRefreshing = true
    }

    fun hideProgressIndication() {
        swipeRefresh.isRefreshing = false
    }

    fun bindQuestionBody(questionBody: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            txtQuestionBody.text = Html.fromHtml(questionBody, Html.FROM_HTML_MODE_LEGACY)
        } else {
            @Suppress("DEPRECATION")
            txtQuestionBody.text = Html.fromHtml(questionBody)
        }
    }
}