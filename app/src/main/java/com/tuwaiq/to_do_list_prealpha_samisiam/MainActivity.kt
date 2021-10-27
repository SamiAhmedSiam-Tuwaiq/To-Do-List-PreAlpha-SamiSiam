package com.tuwaiq.to_do_list_prealpha_samisiam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tuwaiq.to_do_list_prealpha_samisiam.data.model.Task

class MainActivity : AppCompatActivity() {
    // الكود اللي تحت حطيناه في ملف الMainFragment
    //private lateinit var recyclerView: RecyclerView
    // الكود اللي تحت حطيناه في ملف الريبو
    //private var taskData = mutableListOf<Task>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}