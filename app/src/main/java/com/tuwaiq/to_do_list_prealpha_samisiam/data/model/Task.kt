package com.tuwaiq.to_do_list_prealpha_samisiam.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "task_table")
data class Task (
    //● The task’s title
    var taskTitle: String,
    //● An indication of whether the task is completed
    var isTaskCompletedIndication: Boolean,

    //● The task’s due date, if one has been provided by the user:
    //○ If the task is past due, an indication of this fact..(appears?)..If the user taps on the cell, they should
    //see a screen for editing additional task details, including:

    //val taskDueDate: Date?,
    val taskDueDate: Long?,

    //● The creation date
    //val taskEntryTime: Date,
    val taskEntryTime: Long,

    //● All of the information listed above:
    // (a "screen" that has: TaskTitle, isTaskCompleted, TaskDueDate, CreationDate & Description)

    //● An extended description where the user can provide more details about the task
    val taskDescription: String?,

    @PrimaryKey (autoGenerate = true)
    val taskId: Int = 0
) : Parcelable