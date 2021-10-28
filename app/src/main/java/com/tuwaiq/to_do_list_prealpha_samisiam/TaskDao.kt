package com.tuwaiq.to_do_list_prealpha_samisiam
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.tuwaiq.to_do_list_prealpha_samisiam.data.model.Task

@Dao
interface TaskDao {
    @Insert
    suspend fun insert(task: Task)

    @Query("select * From task_table ")
    suspend fun getAllTasks() : List<Task>

    @Update()
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task: Task)

    @Query("select * from task_table where taskId== :uId")
    suspend fun selectUserById(uId: Int): Task
}