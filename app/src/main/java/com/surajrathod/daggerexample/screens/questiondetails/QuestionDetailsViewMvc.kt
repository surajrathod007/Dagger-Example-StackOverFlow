package com.surajrathod.daggerexample.screens.questiondetails

import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.surajrathod.daggerexample.R
import com.surajrathod.daggerexample.questions.QuestionWithBody
import com.surajrathod.daggerexample.screens.common.imageloader.ImageLoader
import com.surajrathod.daggerexample.screens.common.toolbar.MyToolbar
import com.surajrathod.daggerexample.screens.common.viewsMvc.BaseViewMvc

class QuestionDetailsViewMvc(
    layoutInflater: LayoutInflater,
    private val imageLoader: ImageLoader,
    parent: ViewGroup?
) : BaseViewMvc<QuestionDetailsViewMvc.Listener>(layoutInflater,
    parent,
R.layout.layout_question_details) {

    interface Listener{
        fun onBackClicked()
    }

    private var toolbar: MyToolbar
    private var swipeRefresh: SwipeRefreshLayout
    private var txtQuestionBody: TextView
    private var imgUser : ImageView
    private var txtUserName : TextView

    //val rootView = layoutInflater.inflate(R.layout.layout_question_details, parent, false)



    init {

        txtQuestionBody = findViewById(R.id.txt_question_body)
        imgUser = findViewById(R.id.imgUser)
        txtUserName = findViewById(R.id.txtUserName)

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


    fun showProgressIndication() {
        swipeRefresh.isRefreshing = true
    }

    fun hideProgressIndication() {
        swipeRefresh.isRefreshing = false
    }

    fun bindQuestionBody(questionBody: QuestionWithBody) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            txtQuestionBody.text = Html.fromHtml(questionBody.body, Html.FROM_HTML_MODE_LEGACY)
        } else {
            @Suppress("DEPRECATION")
            txtQuestionBody.text = Html.fromHtml(questionBody.body)
        }
        imageLoader.loadImage(questionBody.owner.imageUrl,imgUser)
        txtUserName.text = questionBody.owner.name
    }
}