package com.surajrathod.daggerexample.common.di.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.surajrathod.daggerexample.common.di.app.AppComponent
import com.surajrathod.daggerexample.screens.common.ScreensNavigator
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(
    private val activity: AppCompatActivity,
    private val appComponent: AppComponent
) {

    private val screensNavigator by lazy {
        ScreensNavigator(activity)
    }
    @Provides
    fun screensNavigator() = screensNavigator

    @Provides
    fun layoutInflater() = LayoutInflater.from(activity)

    @Provides
    fun application() = appComponent.application()

    @Provides
    fun fragmentManager() = activity.supportFragmentManager

    @Provides
    fun stackoverflowApi() = appComponent.stackOverFlowApi()

}