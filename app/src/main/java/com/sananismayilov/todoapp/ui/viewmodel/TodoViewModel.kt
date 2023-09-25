package com.sananismayilov.todoapp.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.sananismayilov.todoapp.data.TaskCompleteModel
import com.sananismayilov.todoapp.data.Taskmodel
import com.sananismayilov.todoapp.room.TodoDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class TodoViewModel(application: Application) : AndroidViewModel(application ),CoroutineScope {
    val list = MutableLiveData<List<Taskmodel>>()
    val Completelist = MutableLiveData<List<TaskCompleteModel>>()
    val boolean = MutableLiveData<Boolean>(false)

    fun getTodo(){
        launch {
            val db = TodoDb(getApplication()).getTodoDao()
            val listtemp = db.getTodo()
            list.value = listtemp
            if (listtemp.size == 0){
                boolean.value = true
            }
        }
    }

    fun getCompleteTodo(){
        launch {
            val db = TodoDb(getApplication()).getTodoDao()
            val listcomplete = db.getTodoComplete()
            Completelist.value = listcomplete
        }
    }


    val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    override fun onCleared() {
        job.cancel()
        super.onCleared()
    }

}