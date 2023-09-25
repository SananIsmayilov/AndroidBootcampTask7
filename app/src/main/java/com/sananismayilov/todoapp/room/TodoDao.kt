package com.sananismayilov.todoapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sananismayilov.todoapp.data.TaskCompleteModel
import com.sananismayilov.todoapp.data.Taskmodel

@Dao
interface TodoDao {
    @Query("SELECT *FROM Taskmodel")
    suspend fun getTodo(): List<Taskmodel>


    @Insert(entity = Taskmodel::class)
    suspend fun insertTodo(taskmodel: Taskmodel)

    @Insert(entity = TaskCompleteModel::class)
    suspend fun insertTodoComplete(taskmodelComplete: TaskCompleteModel)

    @Delete(entity = Taskmodel::class)
    suspend fun deleteTodo(taskmodel: Taskmodel)

    @Query("SELECT *FROM TaskCompleteModel")
    suspend fun getTodoComplete(): List<TaskCompleteModel>


}