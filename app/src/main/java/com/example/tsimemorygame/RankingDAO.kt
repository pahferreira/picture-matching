package com.example.tsimemorygame

import android.content.ContentValues
import android.content.Context

class RankingDAO {
    private lateinit var banco: BancoHelper

    constructor(context: Context) {
        this.banco = BancoHelper(context)
    }

    fun insert(p: Ranking) {
        val cv = ContentValues()
        cv.put("nome", p.nome)
        cv.put("score", p.score)
        this.banco.writableDatabase.insert("ranking", null, cv)
    }

    fun get(): ArrayList<Ranking> {
        val colunas = arrayOf("id", "nome", "score")
        val lista = ArrayList<Ranking>()
        val c = this.banco.readableDatabase.query("ranking", colunas, null, null, null, null, "score DESC", "10")
        c.moveToFirst()

        if (c.count > 0) {
            do {
                val id = c.getInt(c.getColumnIndex("id"))
                val nome = c.getString(c.getColumnIndex("nome"))
                val score = c.getInt(c.getColumnIndex("score"))
                lista.add(Ranking(id, nome, score))
            }while (c.moveToNext())
        }
        return lista
    }
}