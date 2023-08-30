package com.example.seminariodelenguajeskotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
class MainActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolBar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = resources.getString(R.string.titulo)


    }
    //crea las opciones del menu, hacia donde podes ir
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //formato del menu, las opciones
        menuInflater.inflate(R.menu.menu_main , menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //si el item tocado es igual a algun id de las opciones, madalo a esa pagina
        if(item.itemId == R.id.itemListado){
            val intentListado = Intent(this, ListadoPersonajes::class.java)
            startActivity(intentListado)
            finish()
        }
        return super.onOptionsItemSelected(item)
    }


}