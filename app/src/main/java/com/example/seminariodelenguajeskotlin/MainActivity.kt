package com.example.seminariodelenguajeskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    private fun saludarUsuario() {
        // Obtengo los datos que me mandaron
        var bundle: Bundle? = intent.extras
        // Reviso que efectivamente tenga datos
        if (bundle != null) {
            // Obtengo el dato especifico
            var nombre = bundle?.getString("nombre")
            var apellido = bundle?.getString("apellido")
            // Muestro el mensaje
            Toast.makeText(this, "Bienvenido/a $nombre $apellido", Toast.LENGTH_SHORT).show()
        }
    }

}