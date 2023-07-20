package com.surajrathod.daggerexample.common.di.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.surajrathod.daggerexample.screens.common.ScreensNavigator
import com.surajrathod.daggerexample.screens.common.ScreensNavigatorImpl
import dagger.Module
import dagger.Provides

@Module
object ActivityModule {


    @Provides
    fun layoutInflater(activity: AppCompatActivity) = LayoutInflater.from(activity)

    @Provides
    fun fragmentManager(activity: AppCompatActivity) = activity.supportFragmentManager

    @Provides
    @ActivityScope
    fun screensNavigator(activity: AppCompatActivity) : ScreensNavigator = ScreensNavigatorImpl(activity)

}

