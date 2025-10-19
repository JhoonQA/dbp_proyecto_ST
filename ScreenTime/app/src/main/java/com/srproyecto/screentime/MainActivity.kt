package com.srproyecto.screentime

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

//        val btnHorario = findViewById<Button>(R.id.btnHorario)
//        val btnUsoDiario = findViewById<Button>(R.id.btnUsoDiario)
//        val btnModos = findViewById<Button>(R.id.btnModos)
//        val btnDescanso = findViewById<Button>(R.id.btnDescanso)
//        val btnConfig = findViewById<Button>(R.id.btnConfig)
//        val btnLimites = findViewById<Button>(R.id.btnLimites)
//        val btnReportes = findViewById<Button>(R.id.btnReportes)
//
//
//        btnHorario.setOnClickListener { navToHorario() }
//        btnUsoDiario.setOnClickListener { navToDiario() }
//        btnModos.setOnClickListener { navToModos() }
//        btnDescanso.setOnClickListener { navToDescanso() }
//        btnConfig.setOnClickListener { navToConfig() }
//        btnLimites.setOnClickListener { navToLimites() }
//        btnReportes.setOnClickListener { navToResportes() }

    }

//    private fun navToHorario() {
//        val inte = Intent(this, reportes::class.java)
//        startActivity(inte)
//    }
//    private fun navToDiario() {
//        val inte = Intent(this, reportes::class.java)
//        startActivity(inte)
//    }
//    private fun navToModos() {
//        val inte = Intent(this, reportes::class.java)
//        startActivity(inte)
//    }
//    private fun navToDescanso() {
//        val inte = Intent(this, reportes::class.java)
//        startActivity(inte)
//    }
//    private fun navToConfig() {
//        val inte = Intent(this, reportes::class.java)
//        startActivity(inte)
//    }
//    private fun navToLimites() {
//        val inte = Intent(this, reportes::class.java)
//        startActivity(inte)
//    }
//    private fun navToResportes() {
//        val inte = Intent(this, reportes::class.java)
//        startActivity(inte)
//    }

}