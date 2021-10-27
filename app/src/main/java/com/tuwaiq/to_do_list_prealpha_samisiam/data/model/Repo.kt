package com.tuwaiq.to_do_list_prealpha_samisiam.data.model

import java.util.*

class Repo {
    fun getAllUsers() : List<Task>{
        val tasks = mutableListOf<Task>()
        for (i in 1..2){
            val task = Task(
                taskTitle = "taskTitle: $i",
                isTaskCompletedIndication = false,
                taskDueDate = null,
                taskEntryTime = Calendar.getInstance().time,
                taskDescription = "description"
            )
            tasks += task
        }
        return tasks
    }
}