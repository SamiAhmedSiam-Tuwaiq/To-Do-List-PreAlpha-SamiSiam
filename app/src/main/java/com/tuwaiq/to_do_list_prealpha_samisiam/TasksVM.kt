package com.tuwaiq.to_do_list_prealpha_samisiam

import android.app.Application
import androidx.lifecycle.*
import com.tuwaiq.to_do_list_prealpha_samisiam.data.model.Repo
import com.tuwaiq.to_do_list_prealpha_samisiam.data.model.Task
import kotlinx.coroutines.launch

class TasksVM(context: Application) : AndroidViewModel(context) {
    private val repo = Repo(context)
    var task = MutableLiveData<Task>()

    fun getAllTasks(): MutableLiveData<List<Task>> {
        val tasks = MutableLiveData<List<Task>>()
        viewModelScope.launch {
            tasks.postValue(repo.getAllTasks())
        }
        return tasks
    }

    fun fillDB() = viewModelScope.launch {
        repo.fillDB()
    }

    fun insert(taskTitle: String): MutableLiveData<Unit> {
        val unit = MutableLiveData<Unit>()
        viewModelScope.launch {
            //repo.insertATask(taskTitle)
            unit.postValue(repo.insertATask(taskTitle))
        }
        return unit
    }

    fun delete(taskToDelete: Task): MutableLiveData<Unit> {
        val unit = MutableLiveData<Unit>()
        viewModelScope.launch { unit.postValue(repo.deleteATask(taskToDelete)) }
        return unit
    }
}


