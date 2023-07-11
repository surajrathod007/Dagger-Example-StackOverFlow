package com.surajrathod.daggerexample.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.surajrathod.daggerexample.MyApplication
import com.surajrathod.daggerexample.common.composition.AppCompositionRoot

open class BaseActivity : AppCompatActivity() {

    val compositionRoot : AppCompositionRoot get() = (application as MyApplication).appCompositionRoot

}