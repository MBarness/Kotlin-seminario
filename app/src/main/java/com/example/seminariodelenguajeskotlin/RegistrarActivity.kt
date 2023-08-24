package com.example.seminariodelenguajeskotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import org.w3c.dom.Text
import java.util.Date

lateinit var eNombre : EditText
lateinit var eApellido : EditText
lateinit var eNacimiento : EditText
lateinit var  eContra : EditText
lateinit var bGuardar: Button


class RegistrarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        eNombre = findViewById(R.id.editNombre)
        eApellido = findViewById(R.id.editApellido)
        eContra = findViewById(R.id.editContraseña)
        bGuardar = findViewById(R.id.bottonGuardarInf)

        bGuardar.setOnClickListener{

            val intent = Intent(this, LogInActivity::class.java)

            val bundle = Bundle()

            bundle.putString("nombre", eNombre.text.toString())
            bundle.putString("apellido", eApellido.text.toString())
            bundle.putString("contra", eContra.text.toString())

            intent.putExtra("datos", bundle)

            startActivity(intent)

        }




    }
}