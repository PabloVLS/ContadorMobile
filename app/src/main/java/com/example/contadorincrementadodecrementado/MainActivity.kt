package com.example.contadorincrementadodecrementado

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val numero = findViewById<TextView>(R.id.numero)
        val btnAumentar = findViewById<Button>(R.id.btnAumentar)
        val btnDiminuir = findViewById<Button>(R.id.btnDiminuir)
        val btnResetar = findViewById<Button>(R.id.btnResetar)
        val btnX1 = findViewById<Button>(R.id.x1)
        val btnX5 = findViewById<Button>(R.id.x5)
        val btnX10 = findViewById<Button>(R.id.x10)

        var multiplicador = 1



        fun atualizar(){
            numero.text = contador.toString()
            btnDiminuir.isEnabled = contador > 0
        }

        btnAumentar.setOnClickListener{
            contador += multiplicador

            atualizar()
        }

        btnDiminuir.setOnClickListener{
            if(contador > 0){
                contador--
                atualizar()
            }
        }

        btnResetar.setOnClickListener {

            AlertDialog.Builder(this)
                .setTitle("Confirmação")
                .setMessage("Tem certeza que deseja zerar o contador?")
                .setPositiveButton("Sim") { _, _ ->
                    contador = 0
                    atualizar()
                }
                .setNegativeButton("Cancelar", null)
                .show()
        }

        fun resetarBotoes() {
            btnX1.isEnabled = true
            btnX5.isEnabled = true
            btnX10.isEnabled = true

            btnX1.setBackgroundColor(getColor(android.R.color.darker_gray))
            btnX5.setBackgroundColor(getColor(android.R.color.darker_gray))
            btnX10.setBackgroundColor(getColor(android.R.color.darker_gray))
        }


        btnX1.setOnClickListener {
            resetarBotoes()
            multiplicador = 1
            btnX1.isEnabled = false
            btnX1.setBackgroundColor(getColor(android.R.color.holo_blue_dark))
        }

        btnX5.setOnClickListener {
            resetarBotoes()
            multiplicador = 5
            btnX5.isEnabled = false
            btnX5.setBackgroundColor(getColor(android.R.color.holo_blue_dark))
        }

        btnX10.setOnClickListener {
            resetarBotoes()
            multiplicador = 10
            btnX10.isEnabled = false
            btnX10.setBackgroundColor(getColor(android.R.color.holo_blue_dark))
        }






        atualizar()
    }
}
