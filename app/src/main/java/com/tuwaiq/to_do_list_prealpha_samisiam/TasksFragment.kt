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

        recyclerView = view.findViewById(R.id.rvTaskView)
        val isLandscape = view.findViewById<FrameLayout>(R.id.taskDetails) != null
        tasksVM = ViewModelProvider(this).get(TasksVM::class.java)
        tasksVM.fillDB()
        tasksVM.getAllTasks().observe(viewLifecycleOwner, {
            recyclerView.adapter = TaskRVAdapter(it, isLandscape)
        })

        recyclerView.layoutManager = LinearLayoutManager(this.context)


    }

}