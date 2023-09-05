package com.example.seminariodelenguajeskotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class AgregarPersonajeActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var nombre: EditText
    lateinit var signo: EditText
    lateinit var boton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_personaje)

        toolbar = findViewById(R.id.toolBar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = resources.getString(R.string.titulo)

        nombre = findViewById(R.id.editNombrePersonaje)
        signo = findViewById(R.id.editsigno)
        boton = findViewById(R.id.botonGuardar)

        boton.setOnClickListener{
            var nombre = nombre.text.toString()
            var signo = signo.text.toString()

            if (nombre.isEmpty() && signo.isEmpty()){
                Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Faltan completar datos", Toast.LENGTH_SHORT).show()
            }


        }



    }
    //invocas el menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //formato del menu, las opciones
        menuInflater.inflate(R.menu.menu_agregar , menu)
        return super.onCreateOptionsMenu(menu)
    }

    // con un if, segun el id tocado te manda a esa pagina/activity
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.logInBack){
            val intentLogIn = Intent(this, LogInActivity::class.java)
            startActivity(intentLogIn)
            Toast.makeText(this, "Cerrando sesion", Toast.LENGTH_SHORT).show()
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}