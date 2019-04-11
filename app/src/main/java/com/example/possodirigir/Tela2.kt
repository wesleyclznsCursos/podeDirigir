package com.example.possodirigir

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_tela2.*

class Tela2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela2)


        //Resgatando o nome de usuário indicado na Main
        val nomeResgatado = intent.getStringExtra("NomeUsuario")

        //Colocando o nome resgatado no txv
        txvNome.text = nomeResgatado

        //Preenchendo o Spinner
        val arrayIdades = arrayListOf<Int>()

        for (umaIdade in 0..100){

            arrayIdades.add(umaIdade)
        }

        val arrayAdaptado = ArrayAdapter(
            this, android.R.layout.simple_spinner_dropdown_item,
            arrayIdades
        )

        spnIdade.adapter = arrayAdaptado

        //verificando a idade e exibindo o resultado
        btnCalcular.setOnClickListener {

            //capturando a idade selecionada
            val idadeSelecionada =spnIdade.selectedItem.toString().toInt()

            //COmparando idade

            if (idadeSelecionada>= 18){
                txvResultado.text = "Pode Dirigir!"
            } else {
                txvResultado.text = "Não pode dirigir!"
            }
        }
    }
}
