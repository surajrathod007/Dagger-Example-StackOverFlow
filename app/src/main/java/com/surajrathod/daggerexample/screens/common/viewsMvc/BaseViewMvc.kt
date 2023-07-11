package com.surajrathod.daggerexample.screens.common.viewsMvc

import com.surajrathod.daggerexample.screens.questiondetails.QuestionDetailsViewMvc


open class BaseViewMvc<LISTENER_TYPE> {

    val listeners = HashSet<LISTENER_TYPE>()

    fun registerListener(listener: LISTENER_TYPE) {
        listeners.add(listener)
    }

    fun unregisterListener(listener: LISTENER_TYPE) {
        listeners.remove(listener)
    }
}