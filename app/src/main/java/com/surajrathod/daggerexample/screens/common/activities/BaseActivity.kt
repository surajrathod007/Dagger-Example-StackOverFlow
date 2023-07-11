package com.surajrathod.daggerexample.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.surajrathod.daggerexample.MyApplication
import com.surajrathod.daggerexample.common.composition.ActivityCompositionRoot
import com.surajrathod.daggerexample.common.composition.AppCompositionRoot

open class BaseActivity : AppCompatActivity() {
    private val appCompositionRoot : AppCompositionRoot get() = (application as MyApplication).appCompositionRoot

    //val compositionRoot : AppCompositionRoot get() = (application as MyApplication).appCompositionRoot
    val compositionRoot : ActivityCompositionRoot by lazy {
        ActivityCompositionRoot(this,appCompositionRoot)
    }

}