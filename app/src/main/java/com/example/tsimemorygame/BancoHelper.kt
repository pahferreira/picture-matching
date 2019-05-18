package com.example.tsimemorygame

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BancoHelper (context: Context): SQLiteOpenHelper(context, "banco_professores_4", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "create table professor (id integer primary key autoincrement, nome text, disciplina text, imagem text)"
        db?.execSQL(sql)
        val sql2 = "create table ranking (id integer primary key autoincrement, nome text, score integer)"
        db?.execSQL(sql2)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}