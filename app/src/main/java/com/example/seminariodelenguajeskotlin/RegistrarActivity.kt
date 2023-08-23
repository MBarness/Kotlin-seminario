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
lateinit var eNacimiento : Text
lateinit var  eContra : EditText
lateinit var bGuardar: Button


class RegistrarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        eNombre = findViewById(R.id.editNombre)
        eApellido = findViewById(R.id.editApellido)
        eNacimiento = findViewById(R.id.editFechaNaci)
        eContra = findViewById(R.id.editContraseña)
        bGuardar = findViewById(R.id.bottonGuardarInf)

        bGuardar.setOnClickListener{
            var intentMain = Intent(this, LogInActivity::class.java)
            Toast.makeText(this, "Se guardaron los datos", Toast.LENGTH_SHORT).show()
            //manda parametros a la actividad
            var nombre = eNombre.text.toString()
            var apellido = eApellido.text.toString()
            var contra = eContra.text.toString()

            intentMain.putExtra("nombre", nombre)
            intentMain.putExtra("apellido", apellido)
            intentMain.putExtra("contraseña", contra)
        }




    }
}