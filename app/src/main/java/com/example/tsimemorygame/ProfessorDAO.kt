package com.example.tsimemorygame

import android.content.ContentValues
import android.content.Context

class ProfessorDAO {
    private lateinit var banco: BancoHelper

    constructor(context: Context) {
        this.banco = BancoHelper(context)
    }

    fun insert(p: Professor) {
        val cv = ContentValues()
        cv.put("nome", p.nome)
        cv.put("disciplina", p.disciplina)
        cv.put("imagem", p.imagem)
        this.banco.writableDatabase.insert("professor", null, cv)
    }

    fun get(): ArrayList<Professor> {
        val colunas = arrayOf("id", "nome", "disciplina", "imagem")
        val lista = ArrayList<Professor>()
        val c = this.banco.readableDatabase.query("professor", colunas, null, null, null, null, "nome")
        c.moveToFirst()

        if (c.count > 0) {
            do {
                val id = c.getInt(c.getColumnIndex("id"))
                val nome = c.getString(c.getColumnIndex("nome"))
                val disciplina = c.getString(c.getColumnIndex("disciplina"))
                val imagem = c.getString(c.getColumnIndex("imagem"))
                lista.add(Professor(id, nome, disciplina, imagem))
            }while (c.moveToNext())
        }
        return lista
    }

    fun find(index: Int): Professor? {
        val colunas = arrayOf("id", "nome", "disciplina", "imagem")
        val where = "id = ?"
        val pwhere = arrayOf(index.toString())
        val c = this.banco.readableDatabase.query("professor", colunas, where, pwhere, null, null, null)

        c.moveToFirst()
        if (c.count > 0) {
            val id = c.getInt(c.getColumnIndex("id"))
            val nome = c.getString(c.getColumnIndex("nome"))
            val disciplina = c.getString(c.getColumnIndex("disciplina"))
            val imagem = c.getString(c.getColumnIndex("imagem"))
            return Professor(id, nome, disciplina, imagem)
        }

        return null
    }

    fun delete(id: Int) {
        val where = "id = ?"
        val pwhere = arrayOf(id.toString())
        this.banco.writableDatabase.delete("professor", where, pwhere)
    }
}