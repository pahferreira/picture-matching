package com.example.tsimemorygame

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class ListActivity : AppCompatActivity() {
    private lateinit var lvProfessores: ListView
    private lateinit var professoresList: ArrayList<Professor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        this.lvProfessores = findViewById(R.id.lvProfessores)
        val bundle: Bundle? = intent.extras


        bundle?.let {
            bundle.apply {
                professoresList = getParcelableArrayList("professores")
            }
        }
        val adapter = ProfessorAdapter(this, professoresList)
        lvProfessores.adapter = adapter
    }
}
