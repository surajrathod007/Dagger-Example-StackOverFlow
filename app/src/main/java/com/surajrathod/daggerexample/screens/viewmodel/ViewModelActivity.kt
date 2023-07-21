package com.surajrathod.daggerexample.screens.viewmodel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.surajrathod.daggerexample.R
import com.surajrathod.daggerexample.screens.common.ScreensNavigator
import com.surajrathod.daggerexample.screens.common.activities.BaseActivity
import com.surajrathod.daggerexample.screens.common.toolbar.MyToolbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ViewModelActivity : BaseActivity() {

    @Inject lateinit var screensNavigator: ScreensNavigator
    private lateinit var vm : MyViewModel

    private lateinit var toolbar: MyToolbar
    private lateinit var txtView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.layout_view_model)
        vm = ViewModelProvider(this).get(MyViewModel::class.java)
        toolbar = findViewById(R.id.toolbar)
        txtView = findViewById(R.id.txtSample)
        toolbar.setNavigateUpListener {
            screensNavigator.navigateBack()
        }
        vm.questions.observe(this){
            txtView.text = "${it.size} $vm"
        }
    }

    companion object{
        fun start(context: Context) {
            val intent = Intent(context, ViewModelActivity::class.java)
            context.startActivity(intent)
        }
    }
}