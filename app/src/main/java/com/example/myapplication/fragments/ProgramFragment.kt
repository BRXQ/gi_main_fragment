package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapters.ProgramListAdapter
import com.example.myapplication.database.MyDatabase

class ProgramFragment : Fragment() {

    private lateinit var myView: View
    private lateinit var myDB : MyDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myView = inflater.inflate(R.layout.fragment_program, container, false)
        myDB = MyDatabase.getDatabase(requireContext())

        val programListAdapter = ProgramListAdapter()
        val programListRecycler = myView.findViewById<RecyclerView>(R.id.programs)

        programListRecycler.adapter = programListAdapter
        programListRecycler.layoutManager = LinearLayoutManager(requireContext())

        programListAdapter.setData(myDB.programDao().getAllExercisesAndPrograms())


        return myView
    }

}