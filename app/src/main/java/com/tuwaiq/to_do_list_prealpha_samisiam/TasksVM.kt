package com.tuwaiq.to_do_list_prealpha_samisiam

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tuwaiq.to_do_list_prealpha_samisiam.data.model.Repo
import com.tuwaiq.to_do_list_prealpha_samisiam.data.model.Task
import kotlinx.coroutines.launch

class TasksVM(context: Application) : AndroidViewModel(context) {
    private val repo = Repo(context)

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
}