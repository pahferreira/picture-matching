package com.example.tsimemorygame

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ProfessorAdapter(private val context: Context,
                       private val dataSource: ArrayList<Professor>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.professor_item, parent, false)
        val tvNomeProfessor = rowView.findViewById(R.id.tvNomeProfessor) as TextView
        val tvDisciplina = rowView.findViewById(R.id.tvDisciplina) as TextView
        val ivFotoProfessor = rowView.findViewById(R.id.ivFotoProfessor) as ImageView

        val professor = getItem(position) as Professor
        tvNomeProfessor.text = professor.nome
        ivFotoProfessor.setImageResource(getImage(professor.imagem))
        tvDisciplina.text = professor.disciplina

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

    fun getImage(imagem: String): Int {
        return context.resources.getIdentifier(imagem, "drawable", context.packageName)
    }
}