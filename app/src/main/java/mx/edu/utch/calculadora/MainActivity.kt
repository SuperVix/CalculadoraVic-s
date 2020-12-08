package mx.edu.utch.calculadora

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var operacion: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        unoBoton.setOnClickListener { numeroPresionado(digito = "1") }
        dosBoton.setOnClickListener { numeroPresionado(digito = "2") }
        tresBoton.setOnClickListener { numeroPresionado(digito = "3") }
        cuatroBoton.setOnClickListener { numeroPresionado(digito = "4") }
        cincoBoton.setOnClickListener { numeroPresionado(digito = "5") }
        seisBoton.setOnClickListener { numeroPresionado(digito = "6") }
        sieteBoton.setOnClickListener { numeroPresionado(digito = "7") }
        ochoBoton.setOnClickListener { numeroPresionado(digito = "8") }
        nueveBoton.setOnClickListener { numeroPresionado(digito = "9") }
        ceroBoton.setOnClickListener { numeroPresionado(digito = "10") }

        masBoton.setOnClickListener { operacionPresionada(SUMA) }
        menosBoton.setOnClickListener { operacionPresionada(RESTA) }
        multiBoton.setOnClickListener { operacionPresionada(MULTIPLICACION) }
        divisionBoton.setOnClickListener { operacionPresionada(DIVISION) }
        clearBoton.setOnClickListener {
            num1 = 0.0
            num2 = 0.0
            resultadoTextView.text = "0"
            operacion = NO_OPERACION
        }
        igualBoton.setOnClickListener {
            var resultado = when(operacion){
                SUMA -> num1 + num2
                RESTA -> num1 - num2
                MULTIPLICACION -> num1 * num2
                DIVISION -> num1 / num2
                else -> 0
            }
            resultadoTextView.text = resultado.toString()
        }
    }

    private fun numeroPresionado(digito: String){
        resultadoTextView.text = "${resultadoTextView.text}$digito"

        if (operacion == NO_OPERACION){
            num1 = resultadoTextView.text.toString().toDouble()
        }else{
            num2 = resultadoTextView.text.toString().toDouble()
        }
    }
    private fun operacionPresionada(operacion: Int){
        this.operacion = operacion

        resultadoTextView.text = "0"
    }

    companion object{
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val NO_OPERACION = 0
    }
    /*Hay disculpe si sale feo, es que nadie de mi familia me quiso prestar su celular y si me lo
    * prestaba era nomas un rato*/
}