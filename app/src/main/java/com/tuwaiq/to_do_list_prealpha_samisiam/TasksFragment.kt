package com.tuwaiq.to_do_list_prealpha_samisiam

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TasksFragment : Fragment() {

    companion object {
        fun newInstance() = TasksFragment()
    }

    private lateinit var tasksVM: TasksVM
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tasks_view_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tasksVM = ViewModelProvider(this).get(TasksVM::class.java)
        val isLandscape = view.findViewById<FrameLayout>(R.id.taskDetails) != null
        recyclerView = view.findViewById(R.id.rvTaskView)
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = TaskRVAdapter(tasksVM.getAllUsers(), isLandscape)

        //These three lines of code, were in the MainActivity.kt (RecyclerViewLesson):
        //recyclerView = findViewById(R.id.rvTaskView)
        //recyclerView.layoutManager = LinearLayoutManager(this)
        //recyclerView.adapter = TaskRVAdapter(taskData)
    }

}