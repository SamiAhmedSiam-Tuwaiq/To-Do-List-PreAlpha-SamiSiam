package com.tuwaiq.to_do_list_prealpha_samisiam

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs

class TaskDetailsFragment : DialogFragment() {

    // (a "screen" that has: TaskTitle,
    // isTaskCompleted,
    // TaskDueDate, CreationDate & Description)
    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }
    private lateinit var tasksVM: TasksVM
    private lateinit var tvTaskTitle: TextView
    private lateinit var tvTaskCompletionIndication: TextView
    private lateinit var tvTaskEntry: TextView
    private lateinit var etTaskDescription: EditText


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.task_details_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tasksVM = ViewModelProvider(this).get(TasksVM::class.java)

        val args: TaskDetailsFragmentArgs by navArgs()
        val task = args.taskDetailsKey


        tvTaskEntry = view.findViewById(R.id.tvCreationDate)
        etTaskDescription = view.findViewById(R.id.etTaskDescription)
        //tvTaskCompletionIndication = view.findViewById(R.id.tvTaskCompletionIndication)
        tvTaskTitle = view.findViewById(R.id.tvEnteredTaskId)
    }

}