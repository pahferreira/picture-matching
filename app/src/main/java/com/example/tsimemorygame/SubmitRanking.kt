package com.example.tsimemorygame

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class SubmitRanking : AppCompatActivity() {
    private lateinit var etNomeJogador: EditText
    private lateinit var btnSubmit: Button
    private lateinit var dao: RankingDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit_ranking)
        this.etNomeJogador = findViewById(R.id.etNomeJogador)
        this.btnSubmit = findViewById(R.id.btnSubmit)
        this.dao = RankingDAO(this)
        this.btnSubmit.setOnClickListener({submitScore(it)})
    }

    fun submitScore(view: View) {
        val nome = this.etNomeJogador.text.toString()
        val score = intent.getIntExtra("total_points", 0)
        this.dao.insert(Ranking(nome, score))
        val it = Intent(this, MainActivity::class.java)
        startActivity(it)
    }
}
