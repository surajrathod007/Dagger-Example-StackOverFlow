package com.surajrathod.daggerexample.screens.viewmodel

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.surajrathod.daggerexample.R
import com.surajrathod.daggerexample.screens.common.ScreensNavigator
import com.surajrathod.daggerexample.screens.common.activities.BaseActivity
import com.surajrathod.daggerexample.screens.common.toolbar.MyToolbar
import java.lang.Exception
import javax.inject.Inject

class ViewModelActivity : BaseActivity() {

    @Inject lateinit var screensNavigator: ScreensNavigator
    @Inject lateinit var myViewModelFactory : MyViewModel.MyViewModelFactory

    private lateinit var toolbar: MyToolbar
    private lateinit var vm : MyViewModel
    private lateinit var txtView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.layout_view_model)
        vm = ViewModelProvider(this,myViewModelFactory).get(MyViewModel::class.java)
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