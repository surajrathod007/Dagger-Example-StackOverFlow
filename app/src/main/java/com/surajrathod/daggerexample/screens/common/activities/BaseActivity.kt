package com.surajrathod.daggerexample.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.surajrathod.daggerexample.MyApplication
import com.surajrathod.daggerexample.common.composition.ActivityCompositionRoot
import com.surajrathod.daggerexample.common.composition.AppCompositionRoot
import com.surajrathod.daggerexample.common.composition.PresentationCompositionRoot

open class BaseActivity : AppCompatActivity() {
    private val appCompositionRoot : AppCompositionRoot get() = (application as MyApplication).appCompositionRoot

    val activityCompositionRoot by lazy {
        ActivityCompositionRoot(this,appCompositionRoot)
    }
    //val compositionRoot : AppCompositionRoot get() = (application as MyApplication).appCompositionRoot
    protected val compositionRoot by lazy {
        PresentationCompositionRoot(activityCompositionRoot)
    }


}