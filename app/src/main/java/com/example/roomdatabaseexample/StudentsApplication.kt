package com.example.roomdatabaseexample

import android.app.Application
import com.example.roomdatabaseexample.repository.StudentRepository
import com.example.roomdatabaseexample.repository.database.StudentDatabase

class StudentsApplication: Application(){

    private val database by lazy { StudentDatabase.getDatabase(context = this) }
    val repository by lazy { StudentRepository(database.studentDao()) }
}