package com.surajrathod.daggerexample.common.di.service

import android.app.Service
import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.surajrathod.daggerexample.screens.common.ScreensNavigator
import dagger.Module
import dagger.Provides

@Module
class ServiceModule(
    private val service: Service,
) {

    @Provides
    fun context() : Context = service

}