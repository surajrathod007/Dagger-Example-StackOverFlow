package com.surajrathod.daggerexample.common.di.service

import com.surajrathod.daggerexample.common.di.presentation.PresentationComponent
import dagger.Subcomponent



@Subcomponent(modules = [ServiceModule::class])
interface ServiceComponent {

}