package com.tuwaiq.to_do_list_prealpha_samisiam.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "task_table")
data class Task (
    val taskTitle: String,
    val isTaskCompletedIndication: Boolean,
    //val taskDueDate: Date?,
    val taskDueDate: Long?,
    //val taskEntryTime: Date,
    val taskEntryTime: Long,
    val taskDescription: String?,
    @PrimaryKey (autoGenerate = true)
    val taskId: Int = 0
) : Parcelable