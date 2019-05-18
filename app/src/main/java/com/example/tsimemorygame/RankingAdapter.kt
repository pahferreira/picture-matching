package com.example.tsimemorygame

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class RankingAdapter(private val context: Context,
                     private val dataSource: ArrayList<Ranking>) : BaseAdapter() {
    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.ranking_item, parent, false)
        val pos = rowView.findViewById(R.id.tvPosition) as TextView
        val nome = rowView.findViewById(R.id.tvNome) as TextView
        val score = rowView.findViewById(R.id.tvScore) as TextView

        val ranking = getItem(position) as Ranking
        pos.text = (position + 1).toString()
        nome.text = ranking.nome
        score.text = ranking.score.toString()

        return rowView
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }

}