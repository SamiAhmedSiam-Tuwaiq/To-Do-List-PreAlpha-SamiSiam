package com.tuwaiq.to_do_list_prealpha_samisiam

import android.os.SystemClock
import java.util.*

data class Task (
    val taskTitle: String,
    val isTaskCompleted: Boolean,
    val taskDueDate: Date?,
    val taskEntryTime: Date,
    val taskDescription: String?
)
