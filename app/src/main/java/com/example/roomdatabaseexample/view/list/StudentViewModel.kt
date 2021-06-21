package com.example.roomdatabaseexample.view.list

import androidx.lifecycle.*
import com.example.roomdatabaseexample.modal.Student
import com.example.roomdatabaseexample.repository.StudentRepository
import kotlinx.coroutines.launch

class StudentViewModel(
    private val repository: StudentRepository
) : ViewModel() {

    // Using LiveData and caching what allStudents returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allStudents: LiveData<List<Student>> = repository.allStudents.asLiveData()

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */


    fun deleteSelectedStudent(student: Student){
        viewModelScope.launch {
            repository.deleteSingleStudent(student)
        }
    }

    fun deleteAllStudents(){
        viewModelScope.launch {
            repository.deleteAllStudents()
        }
    }
}