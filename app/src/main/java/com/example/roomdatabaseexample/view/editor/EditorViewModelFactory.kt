package com.example.roomdatabaseexample.view.editor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomdatabaseexample.repository.StudentRepository
import com.example.roomdatabaseexample.view.list.StudentViewModel

class EditorViewModelFactory(
    private val repository: StudentRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(EditorViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return EditorViewModel(repository) as T
        }
        throw IllegalArgumentException(" Unknown EditorViewModel class")
    }
}