package com.surajrathod.daggerexample.common.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
annotation class ViewModelKey(val value : KClass<out ViewModel>)

//out means providing kotlin class for sub class of ViewModel
