package com.tuwaiq.to_do_list_prealpha_samisiam

import android.opengl.Visibility
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TasksFragment : Fragment() {

    companion object {
        fun newInstance() = TasksFragment()
    }

    private lateinit var tasksVM: TasksVM
    private lateinit var recyclerView: RecyclerView
    lateinit var etEnterATask: EditText
    lateinit var btnSend: ImageButton
    lateinit var tvWelcomeText: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tasks_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvWelcomeText = view.findViewById(R.id.tvWelcomeText)
        btnSend = view.findViewById(R.id.btnSend)
        etEnterATask = view.findViewById(R.id.etEnterATask)
        recyclerView = view.findViewById(R.id.rvTaskView)
        val isLandscape = view.findViewById<FrameLayout>(R.id.taskDetails) != null
        tasksVM = ViewModelProvider(this).get(TasksVM::class.java)
        //tasksVM.fillDB()
        tasksVM.getAllTasks().observe(viewLifecycleOwner, Observer{
            recyclerView.adapter = TaskRVAdapter(it, isLandscape)
            if (it.isEmpty()) tvWelcomeText.visibility = View.VISIBLE
            else tvWelcomeText.visibility = View.GONE
        })
        recyclerView.layoutManager = LinearLayoutManager(this.context)

        btnSend.setOnClickListener {

        val taskTitle:String = etEnterATask.text.toString()
        tasksVM.insert(taskTitle).observe(viewLifecycleOwner, Observer {
            tasksVM.getAllTasks().observe(viewLifecycleOwner, Observer{
                recyclerView.adapter = TaskRVAdapter(it, isLandscape)
                if (it.isEmpty()) tvWelcomeText.visibility = View.VISIBLE
                else tvWelcomeText.visibility = View.GONE
            })
        })
        etEnterATask.text = null
        }
    }


}