package com.example.tsimemorygame

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class RankingActivity : AppCompatActivity() {
    private lateinit var lvRanking: ListView
    private lateinit var ranking: ArrayList<Ranking>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)
        this.lvRanking = findViewById(R.id.lvRanking)

//        val bundle: Bundle? = intent.extras
//
//
//        bundle?.let {
//            bundle.apply {
//                ranking = this.getParcelableArrayList("ranking")
//            }
//        }
        ranking = intent.getSerializableExtra("ranking") as ArrayList<Ranking>
        val adapter = RankingAdapter(this, ranking)
        lvRanking.adapter = adapter
    }
}
