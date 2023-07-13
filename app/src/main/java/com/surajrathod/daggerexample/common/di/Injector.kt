package com.surajrathod.daggerexample.common.di

import com.surajrathod.daggerexample.questions.FetchQuestionsDetailsUseCase
import com.surajrathod.daggerexample.questions.FetchQuestionsUseCase
import com.surajrathod.daggerexample.screens.common.ScreensNavigator
import com.surajrathod.daggerexample.screens.common.dialogs.DialogsNavigator
import com.surajrathod.daggerexample.screens.common.fragments.BaseFragment
import com.surajrathod.daggerexample.screens.common.viewsMvc.ViewMvcFactory
import com.surajrathod.daggerexample.screens.questiondetails.QuestionDetailsActivity
import com.surajrathod.daggerexample.screens.questionslist.QuestionsListFragment
import java.lang.Exception
import java.lang.reflect.Field

class Injector(private val presentationCompositionRoot: PresentationCompositionRoot) {

    fun inject(client : Any) {
        for(field in getAllFields(client)){
            if(isAnnotatedForInjection(field)){
                injectField(client,field)
            }
        }
    }

    private fun injectField(client: Any, field: Field) {
        val isAccessibleInitially = field.isAccessible
        field.isAccessible = true
        field.set(client,getServiceForClass(field.type))
        field.isAccessible = isAccessibleInitially
    }

    private fun getServiceForClass(type: Class<*>?): Any? {
        return when(type){
            DialogsNavigator::class.java->{
                presentationCompositionRoot.dialogsNavigator
            }
            ScreensNavigator::class.java->{
                presentationCompositionRoot.screensNavigator
            }
            FetchQuestionsUseCase::class.java->{
                presentationCompositionRoot.fetchQuestionsUseCase
            }
            FetchQuestionsDetailsUseCase::class.java->{
                presentationCompositionRoot.fetchQuestionsDetailsUseCase
            }
            ViewMvcFactory::class.java->{
                presentationCompositionRoot.viewMvcFactory
            }
            else->{
                throw Exception("Unsupported service type of $type")
            }
        }
    }

    private fun isAnnotatedForInjection(field: Field): Boolean {
        val fieldAnnotations = field.annotations
        for(annotation in fieldAnnotations){
            if(annotation is Service){
                return true
            }
        }
        return false
    }

    private fun getAllFields(client: Any): Array<out Field> {
        val clientClass = client::class.java
        return clientClass.declaredFields
    }

}