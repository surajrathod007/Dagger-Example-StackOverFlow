package com.surajrathod.daggerexample.common.di

import android.app.Application
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.surajrathod.daggerexample.networking.StackoverflowApi
import com.surajrathod.daggerexample.screens.common.ScreensNavigator
import dagger.Component
import dagger.Provides


@Component(modules = [ActivityModule::class])
interface ActivityComponent {

    fun screensNavigator() : ScreensNavigator

    fun layoutInflater() : LayoutInflater

    fun application() : Application

    fun fragmentManager() : FragmentManager

    fun stackoverflowApi() : StackoverflowApi
}