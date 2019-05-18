package com.example.tsimemorygame

import java.io.Serializable

class Ranking : Serializable {
    var id: Int
    var nome: String
    var score: Int

    constructor(id: Int, nome: String, score: Int) {
        this.id = id
        this.nome = nome
        this.score = score
    }

    constructor(nome: String, score: Int) {
        this.id = -1
        this.nome = nome
        this.score = score
    }

    override fun toString(): String {
        return "${nome} - ${score}"
    }
}