package com.example.roomdatabaseexample

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    private val viewModel: StudentViewModel by viewModels {
        StudentViewModelFactory((application as StudentsApplication).repository)
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView = findViewById<RecyclerView>(R.id.students_recycler_view)

        val adapter = StudentListAdapter(listener)
        recyclerView.adapter = adapter

        val editStudent: EditText = findViewById(R.id.edit_student)
        val button: Button = findViewById(R.id.button_save)

        button.setOnClickListener {
            val name = editStudent.text.toString()
            viewModel.insert(Student(name))
        }

        val buttonDeleteAll:Button = findViewById(R.id.delete_all)
        buttonDeleteAll.setOnClickListener{
            viewModel.deleteAllStudents()
        }

        viewModel.allStudents.observe(this, { list ->
            adapter.submitList(list)
        })


    }
    val listener = StudentListAdapter.OnClickListener {

        viewModel.deleteSelectedStudent(it)
    }

}

