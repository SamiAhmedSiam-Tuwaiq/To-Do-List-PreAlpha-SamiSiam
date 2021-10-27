package com.tuwaiq.to_do_list_prealpha_samisiam

import androidx.lifecycle.ViewModel
import com.tuwaiq.to_do_list_prealpha_samisiam.data.model.Repo

// توثيق مفاهيم متدرب كوتلين:
//
class TasksVM : ViewModel() {
    private val repo = Repo()
    fun getAllUsers() = repo.getAllUsers()
}