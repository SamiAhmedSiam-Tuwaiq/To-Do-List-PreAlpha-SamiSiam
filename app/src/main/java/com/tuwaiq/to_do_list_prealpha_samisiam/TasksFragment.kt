package com.tuwaiq.to_do_list_prealpha_samisiam

import android.app.Application
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
import androidx.room.Delete
import com.tuwaiq.to_do_list_prealpha_samisiam.data.model.Task

class TasksFragment : Fragment() {

    companion object {
        fun newInstance() = TasksFragment()
    }

    private lateinit var tasksVM: TasksVM
    private lateinit var recyclerView: RecyclerView
    private lateinit var taskRVAdapter: TaskRVAdapter

    lateinit var etEnterATask: EditText
    lateinit var btnSend: ImageButton
    lateinit var tvWelcomeText: TextView
    lateinit var btnDelete: ImageButton
    lateinit var tasksList: List<Task>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tasks_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //btnDelete = view.findViewById(R.id.iBtnDelete)
        tvWelcomeText = view.findViewById(R.id.tvWelcomeText)
        btnSend = view.findViewById(R.id.btnSend)
        etEnterATask = view.findViewById(R.id.etEnterATask)
        //etEnterATask.text = null
        recyclerView = view.findViewById(R.id.rvTaskView)
        val isLandscape = view.findViewById<FrameLayout>(R.id.taskDetails) != null
        tasksVM = ViewModelProvider(this).get(TasksVM::class.java)
        //tasksVM.fillDB()
        tasksVM.getAllTasks().observe(viewLifecycleOwner, Observer{
            recyclerView.adapter = TaskRVAdapter(it, isLandscape, TasksVM(Application()), tvWelcomeText, view)
            if (it.isEmpty()) tvWelcomeText.visibility = View.VISIBLE
            else tvWelcomeText.visibility = View.GONE
        })
        recyclerView.layoutManager = LinearLayoutManager(this.context)

/*        tasksVM.task.observe(viewLifecycleOwner) {
            task ->
            btnDelete.setOnClickListener {
                tasksVM.delete(task)
                taskRVAdapter
            }
        }*/


        btnSend.setOnClickListener {
//            if (etEnterATask.text.isNotEmpty()) btnSend.visibility = View.VISIBLE
//            else btnSend.visibility = View.GONE
//            if (etEnterATask.text.isNotBlank()) btnSend.visibility = View.VISIBLE
//            else btnSend.visibility = View.GONE
        val taskTitle:String = etEnterATask.text.toString()
        tasksVM.insert(taskTitle).observe(viewLifecycleOwner, Observer {
            tasksVM.getAllTasks().observe(viewLifecycleOwner, Observer{
                recyclerView.adapter = TaskRVAdapter(it, isLandscape, TasksVM(Application()), tvWelcomeText, view)
                welcomeText(it, tvWelcomeText)
            })
        })
        etEnterATask.text = null
        }

    } // onViewCreated


} //TasksFragment

//fun refreshRV() {
//
//}

fun welcomeText(taskList: List<Task>, tvWelcomeText: TextView) {
    if (taskList.isEmpty()) tvWelcomeText.visibility = View.VISIBLE
    else tvWelcomeText.visibility = View.GONE
}