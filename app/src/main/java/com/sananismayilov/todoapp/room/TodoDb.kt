package com.sananismayilov.todoapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.sananismayilov.todoapp.data.TaskCompleteModel
import com.sananismayilov.todoapp.data.Taskmodel

@Database(entities = [Taskmodel::class, TaskCompleteModel::class], version = 2)
abstract class TodoDb : RoomDatabase() {
    abstract fun getTodoDao(): TodoDao


    companion object {

        @Volatile
        var instance: TodoDb? = null

        val lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: makeDatabase(context).also {
                instance = it
            }
        }


        private fun makeDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext, TodoDb::class.java, "Todo"
        ).build()

    }
}
