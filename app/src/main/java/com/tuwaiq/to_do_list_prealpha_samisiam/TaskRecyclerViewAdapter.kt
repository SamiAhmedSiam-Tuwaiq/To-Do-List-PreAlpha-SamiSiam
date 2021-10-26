package com.tuwaiq.to_do_list_prealpha_samisiam

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskRecyclerViewAdapter(private val taskList: List<Task>): RecyclerView.Adapter<TaskAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle_view_item, parent,false)
        return TaskAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskAdapter.ViewHolder, position: Int) {
        val task = taskList[position]
        // اعطاء القيم(assignment) بيكون هنا

        /* Example
        val user = userList[position]
        holder.idTextView.text = user.id.toString()
        holder.nameTextView.text = "${user.fName} ${user.lName}"
        holder.scoreTextView.text = user.score.toString()
        * */
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

}

class TaskAdapter {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        // كود الربط بين الواجهة والمتغيرات في صفحة الكود، هنا
        // Example:
        /*
        val idTextView: TextView = itemView.findViewById(R.id.tvId)
        val nameTextView: TextView = itemView.findViewById(R.id.tvName)
        val scoreTextView: TextView = itemView.findViewById(R.id.tvScore)*/

    }
}