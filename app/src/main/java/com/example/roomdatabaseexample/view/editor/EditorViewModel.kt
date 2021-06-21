package com.example.roomdatabaseexample.view.editor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdatabaseexample.modal.Student
import com.example.roomdatabaseexample.repository.StudentRepository
import kotlinx.coroutines.launch

class EditorViewModel(
    private val repository: StudentRepository
): ViewModel() {

    fun insert(student: Student) = viewModelScope.launch {
        repository.insert(student)
    }

    fun updateSingleStudent(student: Student){
        viewModelScope.launch {
            repository.updateOneStudent(student)
        }
    }
}