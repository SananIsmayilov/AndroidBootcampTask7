package com.sananismayilov.todoapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.navigation.Navigation
import com.sananismayilov.todoapp.R
import com.sananismayilov.todoapp.adapter.CompleteTaskAdapter
import com.sananismayilov.todoapp.adapter.TaskAdapter
import com.sananismayilov.todoapp.data.Taskmodel
import com.sananismayilov.todoapp.databinding.FragmentTodoBinding
import com.sananismayilov.todoapp.ui.viewmodel.AddTaskViewModel
import com.sananismayilov.todoapp.ui.viewmodel.TodoViewModel
import com.sananismayilov.todoapp.util.getPage
import java.util.Calendar


class TodoFragment : Fragment() {
    private lateinit var binding: FragmentTodoBinding
    lateinit var date: String
    lateinit var viewModel: TodoViewModel
    lateinit var addTaskViewModel: AddTaskViewModel
    lateinit var adapter: Taskmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getDate()
        viewModel = ViewModelProviders.of(this).get(TodoViewModel::class.java)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_todo, container, false)
        binding.addtaskpage.setOnClickListener {
            Navigation.getPage(it, R.id.actionaddtask)
        }

        binding.date = date

        observedata()
        return binding.root
    }

    fun getDate() {
        val calendar = Calendar.getInstance()
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        var month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)
        month++;
        when (month) {
            1 -> date = "$day yanvar , $year"
            2 -> date = "$day fevral , $year"
            3 -> date = "$day mart , $year"
            4 -> date = "$day aprel , $year"
            5 -> date = "$day may , $year"
            6 -> date = "$day iyun , $year"
            7 -> date = "$day iyul , $year"
            8 -> date = "$day avqust , $year"
            9 -> date = "$day sentyabr , $year"
            10 -> date = "$day oktyabr , $year"
            11 -> date = "$day noyabr , $year"
            12 -> date = "$day dekabr , $year"
            else -> date = "no date"
        }

    }

    private fun observedata() {
        viewModel.list.observe(viewLifecycleOwner, Observer {
            addTaskViewModel =
                ViewModelProviders.of(requireActivity()).get(AddTaskViewModel::class.java)
            binding.lottianim1.visibility = View.GONE

            val adapter = TaskAdapter(binding.root.context, it, addTaskViewModel)
            binding.adapter = adapter

        })
        viewModel.boolean.observe(viewLifecycleOwner, Observer {
            if (it) {
                binding.lottianim1.visibility = View.VISIBLE
            }
        })


        viewModel.Completelist.observe(viewLifecycleOwner, Observer {
            if (it.size == 0) {

            } else {
                val adapter = CompleteTaskAdapter(binding.root.context, it)
                binding.adapterComplete = adapter
            }
        })


    }

    override fun onResume() {

        viewModel.getTodo()
        viewModel.getCompleteTodo()
        super.onResume()
    }

    override fun onDestroy() {
        observedata()
        super.onDestroy()
    }


}