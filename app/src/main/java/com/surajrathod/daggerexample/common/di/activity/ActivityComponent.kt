package com.surajrathod.daggerexample.common.di.activity

import android.app.Application
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.surajrathod.daggerexample.common.di.app.AppComponent
import com.surajrathod.daggerexample.common.di.presentation.PresentationComponent
import com.surajrathod.daggerexample.common.di.presentation.PresentationModule
import com.surajrathod.daggerexample.common.di.presentation.UseCasesModule
import com.surajrathod.daggerexample.networking.StackoverflowApi
import com.surajrathod.daggerexample.screens.common.ScreensNavigator
import dagger.Component
import dagger.Subcomponent


@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun newPresentationComponent(presentationModule: PresentationModule,useCasesModule: UseCasesModule) : PresentationComponent
}