package com.example.tsimemorygame

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ImageView
import android.widget.Toast
import android.view.ViewGroup
import kotlin.math.floor


class GameActivity : AppCompatActivity() {
    private lateinit var professores: ArrayList<Professor>
    private lateinit var gridView: GridView
    private var drawable = ArrayList<Int>()
    private var currentPos = -1
    private var pos1 = -1
    private var pos2 = -1
    private var score = 0
    private var attempts = 0
    private var currentView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        val bundle: Bundle? = intent.extras

        bundle?.let {
            bundle.apply {
                professores = getParcelableArrayList("professores")
            }
        }
        // Getting Image ID
        professores.forEach {
            drawable.add(this.resources.getIdentifier(it.imagem, "drawable", this.packageName))
        }
        this.gridView = findViewById(R.id.gridView)
        val adapter = CardAdapter(this)
        this.gridView.adapter = adapter
        this.gridView.setOnItemClickListener { parent, view, position, id ->
            if (currentPos < 0) {
                if (pos1 >= 0 && pos2 >= 0) {
                    val view1 = parent.getChildAt(pos1) as ImageView
                    val view2 = parent.getChildAt(pos2) as ImageView
                    view1.setImageResource(R.drawable.question_mark)
                    view2.setImageResource(R.drawable.question_mark)
                }
                currentPos = position
                pos1 = position
                currentView = view as ImageView?
                view?.setImageResource(drawable[position])
            } else {
                attempts++
                if (currentPos != position) {
                    if (drawable[currentPos] != drawable[position]) {
                        currentView = view as ImageView?
                        view?.setImageResource(drawable[position])
                        pos2 = position
                    } else {
                        currentView = view as ImageView?
                        view?.setImageResource(drawable[position])
                        score++
                        parent.getChildAt(currentPos).setOnClickListener {  }
                        view.setOnClickListener {  }
                        pos1 = -1
                        pos2 = -1
                        Toast.makeText(this, professores[position].nome, Toast.LENGTH_SHORT).show()
                        if (score == 8) {
                            val total = ((score * 10000) / attempts).toInt()
                            val it = Intent(this, SubmitRanking::class.java)
                            it.putExtra("total_points", total)
                            startActivity(it)
                        }
                    }
                    currentPos = -1
                }
            }
        }
    }
}
