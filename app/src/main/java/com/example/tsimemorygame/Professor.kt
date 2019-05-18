package com.example.tsimemorygame

import android.os.Parcel
import android.os.Parcelable

class Professor(val id: Int, val nome: String, val disciplina: String, val imagem: String) : Parcelable {

    constructor(parcel: Parcel) : this(
        id = parcel.readInt(),
        nome = parcel.readString(),
        disciplina = parcel.readString(),
        imagem = parcel.readString()
    ) {
    }

//    constructor(id: Int, nome: String, disciplina: ArrayList<String>, imagem: String) {
//        this.id = id
//        this.nome = nome
//        this.disciplinas = disciplina
//        this.imagem = imagem
//    }
//
//    constructor(nome: String, disciplina: ArrayList<String>, imagem: String) {
//        this.id = -1
//        this.nome = nome
//        this.disciplinas = disciplina
//        this.imagem = imagem
//    }

    override fun toString(): String {
        return "${this.nome} - ${imagem} - ${disciplina}"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(nome)
        parcel.writeString(disciplina)
        parcel.writeString(imagem)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Professor> {
        override fun createFromParcel(parcel: Parcel): Professor {
            return Professor(parcel)
        }

        override fun newArray(size: Int): Array<Professor?> {
            return arrayOfNulls(size)
        }
    }
}