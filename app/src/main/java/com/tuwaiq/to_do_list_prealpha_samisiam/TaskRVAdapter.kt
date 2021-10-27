package com.tuwaiq.to_do_list_prealpha_samisiam

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tuwaiq.to_do_list_prealpha_samisiam.data.model.Task

class TaskRVAdapter(private val taskList: List<Task>, private val isLandscape: Boolean): RecyclerView.Adapter<TaskAdapter>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskAdapter {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_recycler_view_item_layout, parent,false)
        return TaskAdapter(view)
    }

    override fun onBindViewHolder(holder: TaskAdapter, position: Int) {
        val task = taskList[position]
        holder.taskTitleTV.text = "[task $position] ${task.taskTitle}"
        holder.taskCreationDateTV.text = task.taskEntryTime.toString()
        // اعطاء القيم(assignment) بيكون هنا
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

}

//class TaskAdapter(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
class TaskAdapter(itemView: View): RecyclerView.ViewHolder(itemView) {
    val taskTitleTV: TextView = itemView.findViewById(R.id.tvEnteredTaskId)
    val taskCreationDateTV: TextView = itemView.findViewById(R.id.tvCreationDate)
        // كود الربط بين الواجهة والمتغيرات في صفحة الكود، هنا

/*    init {
            itemView.setOnClickListener(this)
        }

    override fun onClick(v: View?) {
    //Example:
    //Toast.makeText(itemView.context, "${idTextView.text} clicked", Toast.LENGTH_SHORT).show()
    }*/

}