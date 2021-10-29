package com.tuwaiq.to_do_list_prealpha_samisiam.data.model

import android.content.Context
import com.tuwaiq.to_do_list_prealpha_samisiam.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
//import java.util.*

class Repo(context: Context) {
    private val appDB = AppDatabase.getAppDataBase(context)!!

    suspend fun getAllTasks(): List<Task> = withContext(Dispatchers.IO) {
        appDB.taskDao.getAllTasks()
    }
    suspend fun fillDB() = withContext(Dispatchers.IO) {
        val dataDB = appDB.taskDao.getAllTasks()

        if (dataDB.isEmpty()) {

            /*val task = Task(taskTitle = "Plan your day, add a task", isTaskCompletedIndication = false,
                taskDueDate = 0, taskEntryTime = System.currentTimeMillis(), taskDescription = "description")*/
            //appDB.taskDao.insert(task)
        }
        //Dummy data lines of code:
            /*for (i in 1..100) {
                val task = Task(taskId = i, taskTitle = "taskTitle: $i", isTaskCompletedIndication = false, taskDueDate = 0, taskEntryTime = System.currentTimeMillis(), taskDescription = "description")
                appDB.taskDao.insert(task)
                appDB.taskDao.getAllTasks()
            }*/
    }

    suspend fun insertATask(taskTitleString: String) = withContext(Dispatchers.IO) {
        val task = Task(taskTitle = taskTitleString, isTaskCompletedIndication = false,
            taskDueDate = 0, taskEntryTime = System.currentTimeMillis(), taskDescription = "description")
        appDB.taskDao.insert(task)
    }
}