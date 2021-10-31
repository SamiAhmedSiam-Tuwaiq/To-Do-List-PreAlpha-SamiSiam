package com.tuwaiq.to_do_list_prealpha_samisiam

import android.app.DatePickerDialog
import android.content.ContentValues.TAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.tuwaiq.to_do_list_prealpha_samisiam.data.model.Task
//import android.R
import android.graphics.Paint
import android.icu.text.SimpleDateFormat
import android.util.Log
import android.widget.Toast
import java.util.*


/*الادابتر هوا تبع لستة الريسايكل فيو
وهوا المسئول عن انو يملي الصفحة ب الفيو هولدرز
والفيو هولدر هوا المسؤول عن انو يملي item_view
*/

class TaskRVAdapter(private var taskList: List<Task>,
                    private val isLandscape: Boolean,
                    private val tasksVM: TasksVM,
                    val tvWelcomeText: TextView,
                    private val view: View): RecyclerView.Adapter<TaskAdapter>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskAdapter {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_rv_item_layout, parent,false)
        return TaskAdapter(view)
    }

    override fun onBindViewHolder(holder: TaskAdapter, position: Int) {

        //create object of Calendar
        val calendar = Calendar.getInstance()
        // add day of month
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)
        lateinit var date :String

        val task = taskList[position]

/*
        First prepare the time in mills:
        Long currentTime = System.currentTimeMillis();

        Choose your desire format with SimpleDateFormat:
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");

        Create your date object:
        Date date = new Date(currentTime);

        Apply that format into your date object:
        String time = simpleDateFormat.format(date);

        Log it:
        Log.d(TAG, "onCreate: " + time);

        Result:
        17:05:73*/

        //val currentTime: Long = System.currentTimeMillis()
        val creationCurrentTime = task.taskEntryTime
        val dueDateCurrentTime = task.taskDueDate

        val simpleDateFormat: SimpleDateFormat = SimpleDateFormat("dd/MMMM/yyyy")
//        val simpleDateFormat: SimpleDateFormat = SimpleDateFormat("dd/MMMM(MM)/yyyy")
        val simpleTimeFormat: SimpleDateFormat = SimpleDateFormat("hh:mm:ss")

        val creationObject: Date = Date(creationCurrentTime)
        val dueDateObject: Date = Date(dueDateCurrentTime!!)

        val creationFormattedDate: String = simpleDateFormat.format(creationObject)
        val creationFormattedTime: String = simpleTimeFormat.format(creationObject)

        if (dueDateCurrentTime != null) {
            if (dueDateCurrentTime.equals(0)) {

                val creationObject: Date = Date(creationCurrentTime)
                val dueDateObject: Date = Date(dueDateCurrentTime!!)

                var dueDateFormattedDate: String = simpleDateFormat.format(dueDateObject)
                var dueDateFormattedTime: String = simpleTimeFormat.format(dueDateObject)
                dueDateFormattedDate = "No picked-date available"
                dueDateFormattedTime = "No picked-time available"
            }
        }

        var dueDateFormattedDate: String = simpleDateFormat.format(dueDateObject)
        var dueDateFormattedTime: String = simpleTimeFormat.format(dueDateObject)
        Log.d(TAG, "!!#######!!  Entry-Date: $creationFormattedDate, Entry-Time: $creationFormattedTime!!#######!!\n!!#######!!  Due-Date: $dueDateFormattedDate, Entry-Time: $dueDateFormattedTime!!#######!!")


        holder.taskCreationDateTV.text = "Entry-Date: [$creationFormattedDate, $creationFormattedTime]"
        holder.taskDueDateTV.text = "Due-Date: [$dueDateFormattedDate, $dueDateFormattedTime]"
        holder.taskTitleTV.text = "${task.taskTitle}"
        //holder.
        holder.itemView.setOnClickListener {
            tasksVM.task.postValue(task)
        }
        holder.btnDeleteIB.setOnClickListener {
            tasksVM.delete(task)
            taskList -= task
            notifyItemRemoved(position)
            welcomeText(taskList, tvWelcomeText)
            //notifyDataSetChanged()
            //tasksVM.getAllTasks()
        }
        holder.btnUpdateIB.setOnClickListener {
            val action: NavDirections = TasksFragmentDirections.actionTasksFragmentToUpdateTask(task)
            view.findNavController().navigate(action)
//            tasksVM.update(task)
//            notifyDataSetChanged()
//            welcomeText(taskList, tvWelcomeText)
            //tasksVM.getAllTasks()
        }
        holder.taskTitleTV.setOnClickListener {
            //val someTextView = findViewById(R.id.some_text_view) as TextView
            //someTextView.setText(someString)

            if (holder.taskTitleTV.paintFlags == holder.taskTitleTV.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG) {
                holder.taskTitleTV.paintFlags = holder.taskTitleTV.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
                task.isTaskCompletedIndication = false
                Toast.makeText(view.context, "Task completion has been set to ${task.isTaskCompletedIndication}", Toast.LENGTH_SHORT).show()
            }

            else {
                holder.taskTitleTV.paintFlags = holder.taskTitleTV.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                Toast.makeText(view.context, "\"${task.taskTitle}\" task has been completed, Horrraaaaaaay !! \n(👏👏👏👏 🙌🙌🙌)", Toast.LENGTH_SHORT).show()
                task.isTaskCompletedIndication = true
            }

        }
        holder.btnDueDateIB.setOnClickListener {
                view?.let { it1 ->
                    DatePickerDialog(view.context, DatePickerDialog.OnDateSetListener{ _, d, m, y ->
                        date = "$d/$m/$y"
                        holder.taskDueDateTV.setText(date)
                    },day,month,year)
                        .show()
                }
            }

        }


    override fun getItemCount(): Int {
        return taskList.size
    }

}

//class TaskAdapter(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
class TaskAdapter(itemView: View): RecyclerView.ViewHolder(itemView) {
    val taskTitleTV: TextView = itemView.findViewById(R.id.tvEnteredTaskId)
    val btnDeleteIB: ImageButton = itemView.findViewById(R.id.iBtnDelete)
    val btnUpdateIB: ImageButton = itemView.findViewById(R.id.iBtnEdit)
    val btnDueDateIB: ImageButton = itemView.findViewById(R.id.iBtnDueDate)
    val taskCreationDateTV: TextView = itemView.findViewById(R.id.tvCreationDate)
    val taskDueDateTV: TextView = itemView.findViewById(R.id.tvPickedDate)

/*    init {
            itemView.setOnClickListener(this)
        }

    override fun onClick(v: View?) {
    //Example:
    //Toast.makeText(itemView.context, "${idTextView.text} clicked", Toast.LENGTH_SHORT).show()
    }*/
}