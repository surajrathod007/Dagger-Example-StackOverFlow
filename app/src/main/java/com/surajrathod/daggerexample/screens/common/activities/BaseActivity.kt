package com.surajrathod.daggerexample.screens.common.activities

import androidx.appcompat.app.AppCompatActivity


open class BaseActivity : AppCompatActivity() {

    val activityCompositionRoot by lazy {

    }

    //val compositionRoot : AppCompositionRoot get() = (application as MyApplication).appCompositionRoot
//    protected val compositionRoot by lazy {
//        PresentationModule(activityCompositionRoot)
//    }

    private val presentationComponent by lazy {

    }

    protected val injector get() = presentationComponent


}