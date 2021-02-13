package com.example.calculadoradeimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var calcular = bt_calcular
        var deletar = icone_deletar

        calcular.setOnClickListener {

        var pesoVazio = edit_peso.text.toString()
        var alturaVazio = edit_altura.text.toString()

        if (pesoVazio.isEmpty()){
            mensagem.setText("Informe o seu Peso")
        }    else if (alturaVazio.isEmpty()){
            mensagem.setText("Informe a sua Altura")
        }else{

            CalculoDeIMC()
        }



        }

        deletar.setOnTouchListener { v, event ->

            if (event.action == MotionEvent.ACTION_DOWN){
                edit_peso.setText("")
                edit_altura.setText("")
                mensagem.setText("")
            }


            false  }

    }
    private fun CalculoDeIMC(){
        var peso = Integer.parseInt( edit_peso.text.toString())
        var altura = java.lang.Float.parseFloat(edit_altura.text.toString())
        var resultado = mensagem
        val imc = peso / (altura * altura)


        val mensagem = when{

            imc <=18.5 -> "Peso Baixo"
            imc <24.9  -> "Peso Normal"
            imc <29.9  -> "Sobrepeso"
            imc <34.9  -> "Obesidade (Grau 1)"
            imc <39.9  -> "Obesidade (Grau 2)"
            else -> "Obesidade Mórbida (Grau 3)"

        }
        resultado.text = "IMC:" + " " + imc.toString() + "\n" + mensagem

    }
}