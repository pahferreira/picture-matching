package com.example.tsimemorygame

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var dao: ProfessorDAO
    private lateinit var daoRanking: RankingDAO
    private lateinit var btnPlay: Button
    private lateinit var btnList: Button
    private lateinit var btnListRanking: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.dao = ProfessorDAO(this)
        this.daoRanking = RankingDAO(this)
        this.createData()
        this.btnPlay = findViewById(R.id.btnPlay)
        this.btnList = findViewById(R.id.btnList)
        this.btnListRanking = findViewById(R.id.btnListRanking)
        this.btnPlay.setOnClickListener({startGame(it)})
        this.btnList.setOnClickListener({listTeachers(it)})
        this.btnListRanking.setOnClickListener({ranking(it)})
    }

    fun startGame(view: View) {
        val professores = this.dao.get()
        val professoresSelected = ArrayList<Professor>()
        while (professoresSelected.size < 16) {
            val professor = professores.get(Random.nextInt(0, professores.size))

            if (professor != null) {
                professoresSelected.add(professor)
                professoresSelected.add(0, professor)
                professores.remove(professor)
            }
        }
        (0..10).forEach {
            professoresSelected.shuffle()
        }
        val it = Intent(this, GameActivity::class.java)
        it.putExtra("professores", professoresSelected)
        startActivity(it)
    }

    fun ranking(view: View) {
        val rankingList = this.daoRanking.get()
        val it = Intent(this, RankingActivity::class.java)
        it.putExtra("ranking", rankingList)
        startActivity(it)
    }

    fun listTeachers(view: View) {
        val professores = this.dao.get()
        val it = Intent(this, ListActivity::class.java)
        it.putExtra("professores", professores)
        startActivity(it)
    }

    fun createData() {
        var professores = this.dao.get()

        if (professores.size == 0) {
            this.dao.insert(Professor(1, "Alex Sandro da Cunha Rego", "APE", "alex"))
            this.dao.insert(Professor(2, "Candido Jose Ramos do Egypto", "APE", "candido"))
            this.dao.insert(Professor(3, "Crishane Azevedo Freire", "APE", "crishane"))
            this.dao.insert(Professor(4, "Edemberg Rocha da Silva", "APE", "edemberg"))
            this.dao.insert(Professor(5, "Frederico Costa Guedes Pereira", "Programação para Web II", "fred"))
            this.dao.insert(Professor(6, "Giovanni Loureiro França de Mendonça", "Fundamentos da Computação", "giovanni"))
            this.dao.insert(Professor(7, "José Gomes Quaresma Filho", "Fundamentos de Redes de Computadores", "zefilho"))
            this.dao.insert(Professor(8, "Pryscilla Marcili Dora", "Fundamentos de Redes de Computadores", "pryscilla"))
            this.dao.insert(Professor(9, "Francisco Dantas Nobre Neto", "Linguagem de Marcação", "francisco"))
            this.dao.insert(Professor(10, "Thiago Jose Marques Moura", "Estrutura de Dados", "thiago"))
            this.dao.insert(Professor(11, "Nilton Freire Santos", "Banco de Dados I", "nilton"))
            this.dao.insert(Professor(12, "Lafayette Batista Melo", "Fundamentos da Metodologia", "lafayette"))
            this.dao.insert(Professor(13, "Luiz Carlos Rodrigues Chaves", "Linguagem de Script", "luiz"))
            this.dao.insert(Professor(14, "Leonidas Francisco de Lima Junior", "Protocolos de Interconexão de Redes de Computadores", "leonidas"))
            this.dao.insert(Professor(15, "Gustavo Wagner Diniz Mendes", "Sistemas Operacionais", "gustavo"))
            this.dao.insert(Professor(16, "Alana Marques de Morais",  "Padrões de Projeto de Software", "alana"))
            this.dao.insert(Professor(17, "Damires Yluska de Souza Fernandes", "Banco de Dados II", "damires"))
            this.dao.insert(Professor(18, "Francisco Petrônio Alencar de Medeiros", "Interação Humano-Computador", "petronio"))
            this.dao.insert(Professor(19, "Fausto Veras Maranhão Ayres", "POO - Persistência de Objetos", "fausto"))
            this.dao.insert(Professor(20, "Marcus Vinicius Delgado Varandas", "Legislação Social - Empreendedorismo SI", "varandas"))
            this.dao.insert(Professor(21, "Denio Mariz Timoteo de Sousa", "Segurança de Dados", "denio"))
            this.dao.insert(Professor(22, "Heremita Brasileiro Lira", "Comércio Eletrônico - GPS", "heremita"))
            this.dao.insert(Professor(23, "Valéria Maria Bezerra Cavalcanti Maciel", "Padrões de Projeto de Software - PDM", "valeria"))
        }
    }
}
