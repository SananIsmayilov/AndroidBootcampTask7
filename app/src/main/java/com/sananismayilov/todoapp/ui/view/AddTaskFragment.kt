package com.sananismayilov.todoapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.navigation.Navigation
import com.sananismayilov.todoapp.R
import com.sananismayilov.todoapp.databinding.FragmentAddTaskBinding
import com.sananismayilov.todoapp.ui.viewmodel.AddTaskViewModel
import com.sananismayilov.todoapp.util.getPage
import java.util.Calendar


class AddTaskFragment : Fragment(R.layout.fragment_add_task) {
    lateinit var binding: FragmentAddTaskBinding
    private lateinit var date: String
    lateinit var model: AddTaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getDate()
        model = ViewModelProviders.of(this).get(AddTaskViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddTaskBinding.inflate(inflater, container, false)
        binding.datetextaddpage.text = date
        binding.addtask.setOnClickListener {
            insertTask()
        }


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

    fun insertTask() {
        val todocapt = binding.captiontodo.text.toString()
        val tododesc = binding.desctodo.text.toString()
        model.insertTodo(todocapt, tododesc, date)
        Navigation.getPage(binding.addtask, R.id.actionmainpage)
    }


}