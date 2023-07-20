package com.surajrathod.daggerexample.common.di.presentation

import androidx.lifecycle.ViewModel
import com.surajrathod.daggerexample.common.di.ViewModelKey
import com.surajrathod.daggerexample.screens.viewmodel.MyViewModel
import com.surajrathod.daggerexample.screens.viewmodel.MyViewModel2
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MyViewModel::class)
    abstract fun myViewModel(myViewModel: MyViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MyViewModel2::class)
    abstract fun myViewModel2(myViewModel2: MyViewModel2) : ViewModel
}