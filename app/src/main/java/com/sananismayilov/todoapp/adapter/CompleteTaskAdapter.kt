package com.sananismayilov.todoapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sananismayilov.todoapp.R
import com.sananismayilov.todoapp.data.TaskCompleteModel
import com.sananismayilov.todoapp.data.Taskmodel
import com.sananismayilov.todoapp.databinding.TaskviewlistBinding
import com.sananismayilov.todoapp.databinding.TaskviewlistcompleteBinding

class CompleteTaskAdapter(val context: Context, val list: List<TaskCompleteModel>) :
    RecyclerView.Adapter<CompleteTaskAdapter.TaskHolder>() {

    inner class TaskHolder(val binding: TaskviewlistcompleteBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
        val binding = DataBindingUtil.inflate<TaskviewlistcompleteBinding>(
            LayoutInflater.from(parent.context),
            R.layout.taskviewlistcomplete, parent, false
        )
        return TaskHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        holder.binding.taskmodel = list.get(position)
        holder.binding.checktask.isChecked = true

    }
}