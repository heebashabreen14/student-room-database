package com.example.roomdatabaseexample.view.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabaseexample.R
import com.example.roomdatabaseexample.StudentsApplication
import com.example.roomdatabaseexample.modal.Student
import com.example.roomdatabaseexample.view.detail.DetailFragment

class StudentListFragment : Fragment() {

    private val viewModel: StudentViewModel by viewModels {
        StudentViewModelFactory((requireActivity().application as StudentsApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.students_recycler_view)
        val buttonDeleteAll: Button = view.findViewById(R.id.delete_all)
        val editStudent: EditText = view.findViewById(R.id.edit_student)
        val button: Button = view.findViewById(R.id.button_save)

        val adapter = StudentListAdapter(listener)
        recyclerView.adapter = adapter

        button.setOnClickListener {
            val name = editStudent.text.toString()
            viewModel.insert(Student(name))
        }

        buttonDeleteAll.setOnClickListener{
            viewModel.deleteAllStudents()
        }

        viewModel.allStudents.observe(viewLifecycleOwner, { list ->
            adapter.submitList(list)
        })

    }

    private val listener = StudentListAdapter.OnClickListener {
       findNavController().navigate(
           StudentListFragmentDirections.actionStudentListFragmentToDetailFragment(it)
       )
    }



}
