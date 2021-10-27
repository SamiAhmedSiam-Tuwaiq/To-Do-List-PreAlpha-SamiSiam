package com.tuwaiq.to_do_list_prealpha_samisiam.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Task (
    val taskTitle: String,
    val isTaskCompletedIndication: Boolean,
    val taskDueDate: Date?,
    val taskEntryTime: Date,
    val taskDescription: String?
) : Parcelable
