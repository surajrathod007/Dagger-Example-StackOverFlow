package com.surajrathod.daggerexample.common.service

import android.app.Service
import com.surajrathod.daggerexample.MyApplication
import com.surajrathod.daggerexample.common.di.service.ServiceModule

abstract class BaseService : Service() {


    val serviceComponent by lazy {

    }

}