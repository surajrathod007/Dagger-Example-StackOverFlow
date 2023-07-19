package com.surajrathod.daggerexample.common.di.activity

import com.surajrathod.daggerexample.common.di.presentation.PresentationComponent
import dagger.Subcomponent


@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun newPresentationComponent() : PresentationComponent
}