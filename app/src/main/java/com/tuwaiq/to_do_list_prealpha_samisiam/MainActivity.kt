package com.tuwaiq.to_do_list_prealpha_samisiam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock.currentGnssTimeClock
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private var taskData = mutableListOf<Task>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvTask)

        for (i in 1..2){
            val user = Task(
                "taskTitle: $i",
                false,
                taskDueDate = null,
                taskEntryTime = Calendar.getInstance().time,
                taskDescription = "description"
            )
            taskData += user
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        //recyclerView.adapter = UserRecycleViewAdapter(taskData)
    }
}