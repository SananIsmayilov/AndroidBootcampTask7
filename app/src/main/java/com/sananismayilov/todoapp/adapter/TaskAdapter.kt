package com.sananismayilov.todoapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sananismayilov.todoapp.R
import com.sananismayilov.todoapp.data.Taskmodel
import com.sananismayilov.todoapp.databinding.TaskviewlistBinding
import com.sananismayilov.todoapp.ui.viewmodel.AddTaskViewModel

class TaskAdapter(
    val context: Context,
    val list: List<Taskmodel>,
    var addTaskViewModel: AddTaskViewModel
) : RecyclerView.Adapter<TaskAdapter.TaskHolder>() {
    inner class TaskHolder(val binding: TaskviewlistBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
        val binding = DataBindingUtil.inflate<TaskviewlistBinding>(
            LayoutInflater.from(parent.context),
            R.layout.taskviewlist, parent, false
        )
        return TaskHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        holder.binding.taskmodel = list.get(position)
        holder.binding.checktask.setOnCheckedChangeListener { view, ischecked ->
            if (ischecked) {
                addTaskViewModel.insertTodoComplete(
                    list.get(position).taskname,
                    list.get(position).taskdesc,
                    list[position].taskdate
                )
                addTaskViewModel.deleteTodo(
                    list[position].id,
                    list.get(position).taskname,
                    list.get(position).taskdesc,
                    list[position].taskdate
                )
                notifyDataSetChanged()
            }

        }
    }


}