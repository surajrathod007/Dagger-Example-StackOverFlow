package com.surajrathod.daggerexample.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.surajrathod.daggerexample.MyApplication
import com.surajrathod.daggerexample.common.di.activity.ActivityModule
import com.surajrathod.daggerexample.common.di.app.AppComponent
import com.surajrathod.daggerexample.common.di.activity.DaggerActivityComponent
import com.surajrathod.daggerexample.common.di.presentation.DaggerPresentationComponent
import com.surajrathod.daggerexample.common.di.presentation.PresentationModule

open class BaseActivity : AppCompatActivity() {
    private val appComponent: AppComponent get() = (application as MyApplication).appComponent

    val activityCompositionRoot by lazy {
        DaggerActivityComponent.builder().activityModule(ActivityModule(this,appComponent)).build()
    }

    //val compositionRoot : AppCompositionRoot get() = (application as MyApplication).appCompositionRoot
//    protected val compositionRoot by lazy {
//        PresentationModule(activityCompositionRoot)
//    }

    private val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .presentationModule(PresentationModule(activityCompositionRoot)).build()
    }

    protected val injector get() = presentationComponent


}