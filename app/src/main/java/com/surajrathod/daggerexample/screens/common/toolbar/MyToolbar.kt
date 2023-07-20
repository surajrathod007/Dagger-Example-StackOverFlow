package com.surajrathod.daggerexample.screens.common.toolbar

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.widget.Toolbar
import com.surajrathod.daggerexample.R


class MyToolbar : Toolbar {

    interface NavigateUpListener {
        fun onNavigationUpClicked() : () -> Unit

    }
    interface ButtonClicks{
        fun onViewModelButtonClicked()
    }

    private var navigateUpListener: () -> Unit = {}
    private var viewModelListener: () -> Unit = {}
    private lateinit var btnClickListener : ButtonClicks

    private lateinit var navigateUp: FrameLayout
    private lateinit var btnViewModel : Button

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context)
    }

    private fun init(context: Context) {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_my_toolbar, this, true)
        setContentInsetsRelative(0, 0)
        navigateUp = view.findViewById(R.id.navigate_up)
        btnViewModel = view.findViewById(R.id.btn_view_model)
        btnViewModel.setOnClickListener {
            viewModelListener.invoke()
        }
        navigateUp.setOnClickListener { navigateUpListener.invoke() }
    }

    fun setNavigateUpListener(navigateUpListener: () -> Unit) {
        this.navigateUpListener = navigateUpListener
        navigateUp.visibility = View.VISIBLE
        btnViewModel.visibility = View.GONE
    }

    fun setupViewModelListener(viewModelListener : () -> Unit){
        this.viewModelListener = viewModelListener
    }
}