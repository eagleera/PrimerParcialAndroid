package com.example.primerparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.primerparcial.R.color
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var prodActual :Int = 0
    var porcentaje :Double = 0.0
    var prodTotalManzanas :Int = 0
    var prodActualManzanas :Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn5.setOnClickListener {
            addActual(5)
        }
        btn15.setOnClickListener {
            addActual(15)
        }
        btn30.setOnClickListener {
            addActual(30)
        }
        btn50.setOnClickListener {
            addActual(50)
        }
        btnCalcular.setOnClickListener{
            calcularPorcentaje()
        }
        btnProdTotal.setOnClickListener {
            prodTotalManzanas = txtProdTotal.text.toString().toInt() * 80
            Toast.makeText(this,"tu meta es de ${ prodTotalManzanas } manzanas", Toast.LENGTH_LONG).show()
        }
        btnProdActual.setOnClickListener {
            prodActualManzanas  = txtProdActual.text.toString().toInt() * 80
            Toast.makeText(this,"llevas ${ prodActualManzanas } manzanas", Toast.LENGTH_LONG).show()
        }
    }
    private fun addActual(number: Int){
        prodActual = txtProdActual.text.toString().toInt()
        if((prodActual + number) > txtProdTotal.text.toString().toInt()){
            Toast.makeText(this,"ya te pasaste mijo", Toast.LENGTH_LONG).show()
        }else{
            prodActual += number;
            txtProdActual.setText(prodActual.toString())
        }
    }
    private fun calcularPorcentaje(){
        porcentaje = (((txtProdActual.text.toString().toInt() * 100) / txtProdTotal.text.toString().toInt()).toDouble())
        txtPorcentaje.setText(porcentaje.toString())
        if(porcentaje >= 70 ){
            main.setBackgroundColor(getResources().getColor(color.red))
        }
    }
}
