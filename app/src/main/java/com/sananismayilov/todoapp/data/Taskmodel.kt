package com.sananismayilov.todoapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class Taskmodel
    (
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo("taskname") var taskname: String,
    @ColumnInfo("daskdescription") var taskdesc: String,
    @ColumnInfo("taskdate") var taskdate: String,
)