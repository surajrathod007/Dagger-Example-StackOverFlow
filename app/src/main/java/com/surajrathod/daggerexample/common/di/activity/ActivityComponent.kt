package com.surajrathod.daggerexample.common.di.activity

import android.app.Application
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.surajrathod.daggerexample.common.di.app.AppComponent
import com.surajrathod.daggerexample.networking.StackoverflowApi
import com.surajrathod.daggerexample.screens.common.ScreensNavigator
import dagger.Component


@ActivityScope
@Component(modules = [ActivityModule::class], dependencies = [AppComponent::class])
interface ActivityComponent {

    fun screensNavigator() : ScreensNavigator

    fun layoutInflater() : LayoutInflater

    fun activity() : AppCompatActivity

    fun fragmentManager() : FragmentManager

    fun stackoverflowApi() : StackoverflowApi
}