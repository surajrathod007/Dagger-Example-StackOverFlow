package com.surajrathod.daggerexample.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.surajrathod.daggerexample.MyApplication
import com.surajrathod.daggerexample.common.di.activity.ActivityModule
import com.surajrathod.daggerexample.common.di.app.AppComponent

open class BaseActivity : AppCompatActivity() {
    private val appComponent: AppComponent get() = (application as MyApplication).appComponent

    val activityCompositionRoot by lazy {
        appComponent.newActivityComponentBuilder().activity(this).activityModule(ActivityModule).build()
    }

    //val compositionRoot : AppCompositionRoot get() = (application as MyApplication).appCompositionRoot
//    protected val compositionRoot by lazy {
//        PresentationModule(activityCompositionRoot)
//    }

    private val presentationComponent by lazy {
        activityCompositionRoot.newPresentationComponent()
    }

    protected val injector get() = presentationComponent


}