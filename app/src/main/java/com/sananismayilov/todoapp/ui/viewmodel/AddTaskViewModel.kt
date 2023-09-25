package com.sananismayilov.todoapp.ui.viewmodel

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sananismayilov.todoapp.data.TaskCompleteModel
import com.sananismayilov.todoapp.data.Taskmodel
import com.sananismayilov.todoapp.room.TodoDb

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.job
import kotlinx.coroutines.launch


import kotlin.coroutines.CoroutineContext


class AddTaskViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {


    fun insertTodo(todocapt: String, tododesc: String, tododate: String) {
        launch {
            try {
                val db = TodoDb(getApplication()).getTodoDao()
                val taskmodel = Taskmodel(0, todocapt, tododesc, tododate)
                db.insertTodo(taskmodel)
            } catch (e: Exception) {
                println("Problem $e")
            }

        }
    }

    fun insertTodoComplete(todocapt: String, tododesc: String, tododate: String) {
        launch {
            try {
                val db = TodoDb(getApplication()).getTodoDao()
                val taskCompleteModel = TaskCompleteModel(0, todocapt, tododesc, tododate)
                db.insertTodoComplete(taskCompleteModel)
            } catch (e: Exception) {
                println("Problem $e")
            }

        }
    }

    fun deleteTodo(todoid : Int,todocapt: String, tododesc: String, tododate: String) {
        launch {
            try {
                val db = TodoDb(getApplication()).getTodoDao()
                val taskmodel = Taskmodel(todoid, todocapt, tododesc, tododate)
                db.deleteTodo(taskmodel)
            } catch (e: Exception) {
                println("Problem $e")
            }

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