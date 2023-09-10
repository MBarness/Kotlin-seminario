package com.example.seminariodelenguajeskotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import org.w3c.dom.Text
import java.util.Date


class RegistrarActivity : AppCompatActivity() {

    lateinit var eNombre : EditText
    lateinit var eApellido : EditText
    lateinit var eNacimiento : EditText
    lateinit var  eContra : EditText
    lateinit var bGuardar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        eNombre = findViewById(R.id.editNombre)
        eApellido = findViewById(R.id.editApellido)
        eContra = findViewById(R.id.editContraseña)
        bGuardar = findViewById(R.id.bottonGuardarInf)

        bGuardar.setOnClickListener{

            val intent = Intent(this, LogInActivity::class.java)

            var nombre = eContra.text.toString()
            var contra = eContra.text.toString()

            var preferencias = getSharedPreferences(resources.getString(R.string.sp_credenciales), MODE_PRIVATE)
            preferencias.edit().putString(resources.getString(R.string.nombre_usuario), nombre).apply()
            preferencias.edit().putString(resources.getString(R.string.contraseña), contra).apply()
            startActivity(intent)
        }
    }
}