package com.sananismayilov.todoapp.util

import android.view.View
import androidx.navigation.Navigation

fun Navigation.getPage(view: View, id: Int) {
    Navigation.findNavController(view).navigate(id)
}