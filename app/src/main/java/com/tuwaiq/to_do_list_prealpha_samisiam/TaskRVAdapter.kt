package com.tuwaiq.to_do_list_prealpha_samisiam

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.tuwaiq.to_do_list_prealpha_samisiam.data.model.Task

/*الادابتر هوا تبع لستة الريسايكل فيو
وهوا المسئول عن انو يملي الصفحة ب الفيو هولدرز
والفيو هولدر هوا المسؤول عن انو يملي item_view
*/

class TaskRVAdapter(private var taskList: List<Task>, private val isLandscape: Boolean, private val tasksVM: TasksVM, val tvWelcomeText: TextView): RecyclerView.Adapter<TaskAdapter>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskAdapter {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_rv_item_layout, parent,false)
        return TaskAdapter(view)
    }

    override fun onBindViewHolder(holder: TaskAdapter, position: Int) {
        val task = taskList[position]

        holder.taskTitleTV.text = "${task.taskTitle}"
        holder.itemView.setOnClickListener {
            tasksVM.task.postValue(task)
        }
        holder.btnDelete.setOnClickListener {
            tasksVM.delete(task)
            taskList -= task
            notifyItemRemoved(position)
            welcomeText(taskList, tvWelcomeText)
            //notifyDataSetChanged()
            //tasksVM.getAllTasks()
        }

    }

    override fun getItemCount(): Int {
        return taskList.size
    }

}

//class TaskAdapter(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
class TaskAdapter(itemView: View): RecyclerView.ViewHolder(itemView) {
    val taskTitleTV: TextView = itemView.findViewById(R.id.tvEnteredTaskId)
    val btnDelete: ImageButton = itemView.findViewById(R.id.iBtnDelete)
//    val taskCreationDateTV: TextView = itemView.findViewById(R.id.tvCreationDate)
    //val taskTitleET: EditText = itemView.findViewById(R.id.etTaskEntry)
        // كود الربط بين الواجهة والمتغيرات في صفحة الكود، هنا

/*    init {
            itemView.setOnClickListener(this)
        }

    override fun onClick(v: View?) {
    //Example:
    //Toast.makeText(itemView.context, "${idTextView.text} clicked", Toast.LENGTH_SHORT).show()
    }*/
}