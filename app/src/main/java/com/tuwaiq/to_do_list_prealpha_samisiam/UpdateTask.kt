package com.tuwaiq.to_do_list_prealpha_samisiam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.tuwaiq.to_do_list_prealpha_samisiam.data.model.Task
import kotlinx.android.synthetic.main.fragment_update_task.*

class UpdateTask : DialogFragment() {

    private lateinit var tasksVM: TasksVM
    private lateinit var updateTask: EditText
    private lateinit var btnSendUpdate: ImageButton

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tasksVM = ViewModelProvider(this).get(TasksVM::class.java)

        val args: UpdateTaskArgs by navArgs()
        val task = args.taskKey


        updateTask = view.findViewById(R.id.etUpdateTask)
        btnSendUpdate = view.findViewById(R.id.btnSend)

        btnSendUpdate.setOnClickListener {
            val newTaskTitle:String = etUpdateTask.text.toString()
            //var task = Task()
            task.taskTitle = newTaskTitle
            tasksVM.update(task)
            //welcomeText()
            dismiss()
        }
    }

}