package com.surajrathod.daggerexample.common.di.activity

import androidx.appcompat.app.AppCompatActivity
import com.surajrathod.daggerexample.common.di.presentation.PresentationComponent
import dagger.BindsInstance
import dagger.Subcomponent


@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun newPresentationComponent() : PresentationComponent

    @Subcomponent.Builder
    interface Builder{
        @BindsInstance fun activity(activity : AppCompatActivity) : Builder
        fun build() : ActivityComponent
    }
}