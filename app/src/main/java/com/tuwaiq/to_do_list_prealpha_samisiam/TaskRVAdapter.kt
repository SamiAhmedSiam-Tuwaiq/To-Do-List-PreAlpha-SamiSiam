package com.tuwaiq.to_do_list_prealpha_samisiam

import android.app.DatePickerDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.tuwaiq.to_do_list_prealpha_samisiam.data.model.Task
//import android.R
import android.graphics.Paint
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
        holder.btnUpdate.setOnClickListener {
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
            if (holder.taskTitleTV.paintFlags == holder.taskTitleTV.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG)
                holder.taskTitleTV.setPaintFlags(holder.taskTitleTV.getPaintFlags() and Paint.STRIKE_THRU_TEXT_FLAG.inv())
            else holder.taskTitleTV.paintFlags = holder.taskTitleTV.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
/*        holder.btnDueDate.setOnClickListener {
                view?.let { it1 ->
                    DatePickerDialog(it1, DatePickerDialog.OnDateSetListener{ _, y, m, d ->
                        date = "$d/$m/$y"
                        holder.btnDueDate.setText(date)
                    },year,month, day)
                        .show()
                }
            }*/

        }


    override fun getItemCount(): Int {
        return taskList.size
    }

}

//class TaskAdapter(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
class TaskAdapter(itemView: View): RecyclerView.ViewHolder(itemView) {
    val taskTitleTV: TextView = itemView.findViewById(R.id.tvEnteredTaskId)
    val btnDelete: ImageButton = itemView.findViewById(R.id.iBtnDelete)
    val btnUpdate: ImageButton = itemView.findViewById(R.id.iBtnEdit)
//    val btnDueDate: ImageButton = itemView.findViewById(R.id.iBtnDueDate)
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