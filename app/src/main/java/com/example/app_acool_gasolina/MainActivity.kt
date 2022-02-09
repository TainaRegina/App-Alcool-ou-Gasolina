package com.example.app_acool_gasolina

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

//a função foi chamada no onclick do xml do botão
    fun btCalcular(view: View) {

        //recupera valores digitados
        val precoAlcool = editTextNumberAcool.text.toString()
        val precoGasolina = editTextNumberGasolina.text.toString()

        val validaCampos = validarCampos(precoAlcool, precoGasolina)

        if (validaCampos != null) {
            calcularMelhorPreco(precoAlcool, precoGasolina)
        } else {
            text_resultado.setText("Preencha os preços primeiro!")
        }
    }


    fun validarCampos(precoAlcool: String, precoGasolina: String) {
        var camposValidados: Boolean = true

        if (precoAlcool == null || precoAlcool.equals("")) {
            camposValidados = false
        } else if (precoGasolina == null || precoGasolina.equals(""))
            camposValidados = false
    }




    fun calcularMelhorPreco(precoAlcool: String, precoGasolina: String) {

        //Converte valores string para numeros
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        /** Faz calculo (precoAlcool/ precoGasoliina)
         * Se resultado >= 0.7 melhor utilizar gasolina
         * senão melhor utilizar Alcool
         */

        val resultadoPreco = valorAlcool / valorGasolina

        if (resultadoPreco >= 0.7) {
            text_resultado.setText("Melhor utlizar Gasolina!")
        } else {
            text_resultado.setText("Melhor utilizar Ácool!")
        }


    }
}