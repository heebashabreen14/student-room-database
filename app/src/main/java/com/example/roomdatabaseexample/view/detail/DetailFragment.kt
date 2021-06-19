package com.example.roomdatabaseexample.view.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.roomdatabaseexample.R
import com.example.roomdatabaseexample.modal.Student

class DetailFragment : Fragment() {

    lateinit var studentDetailArgs : Student

    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         studentDetailArgs = DetailFragmentArgs.fromBundle(requireArguments()).studentDetailArgs

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val studentDetail = view.findViewById<TextView>(R.id.detail_text_view)
        studentDetail.text = studentDetailArgs.studentName
    }
}

