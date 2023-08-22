package com.example.seminariodelenguajeskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import org.w3c.dom.Text
import java.util.Date

lateinit var eNombre : EditText
lateinit var eApellido : EditText
lateinit var eNacimiento : Text
lateinit var bGuardar: Button


class RegistrarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        eNombre = findViewById(R.id.editNombre)
        eApellido = findViewById(R.id.editApellido)
        eNacimiento = findViewById(R.id.editFechaNaci)
        bGuardar = findViewById(R.id.bottonGuardarInf)






    }
}