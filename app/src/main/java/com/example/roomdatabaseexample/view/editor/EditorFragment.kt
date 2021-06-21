package com.example.roomdatabaseexample.view.editor

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.roomdatabaseexample.R
import com.example.roomdatabaseexample.StudentsApplication
import com.example.roomdatabaseexample.modal.Student
import com.example.roomdatabaseexample.view.list.StudentViewModel
import com.example.roomdatabaseexample.view.list.StudentViewModelFactory

class EditorFragment : Fragment() {

    var student: Student? = null
    private val viewModel: EditorViewModel by viewModels {
        EditorViewModelFactory((requireActivity().application as StudentsApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        student = EditorFragmentArgs.fromBundle(requireArguments()).editStudentDataArgs
        Log.e("Editor Fragment", student?.studentName.toString())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("Editor Fragment", "on Create view")
        return inflater.inflate(R.layout.fragment_editor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editStudent: EditText = view.findViewById(R.id.edit_student)
        val button: Button = view.findViewById(R.id.button_save)
        val updateButton = view.findViewById<Button>(R.id.button_update)
        editStudent.setText(student?.studentName)


        Log.e("Editor Fragment", "On View Created")
        button.setOnClickListener {
            val name = editStudent.text.toString()
            viewModel.insert(Student(2,name))
            findNavController().navigateUp()
        }

        updateButton.setOnClickListener{
            val updatedname = editStudent.text.toString()
            viewModel.updateSingleStudent(Student(2,updatedname))
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Editor Fragment", "Destroy")
    }


}