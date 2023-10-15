package com.example.seminariodelenguajeskotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView

class ListadoPersonajes : AppCompatActivity() {
    lateinit var rvPersonajes: RecyclerView
    lateinit var personajesAdapter : PersonajesAdapter
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_personajes)

        //carga la lista
        rvPersonajes = findViewById(R.id.rcListadoPersonajes)
        //vincula con el adapter
        personajesAdapter = PersonajesAdapter(getPersonajes(),this)
        rvPersonajes.adapter = personajesAdapter

        toolbar = findViewById(R.id.toolBar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = resources.getString(R.string.boton_listado)

    }
    //invocas el menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //formato del menu, las opciones
        menuInflater.inflate(R.menu.menu_listado , menu)
        return super.onCreateOptionsMenu(menu)
    }

    // con un if, segun el id tocado te manda a esa pagina/activity
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.itemAgregar){
            val intentAgregar = Intent(this, AgregarPersonajeActivity::class.java)
            startActivity(intentAgregar)
            finish()
        }
        if(item.itemId == R.id.backButton){
            val intentLogIn = Intent(this, MainActivity::class.java)
            startActivity(intentLogIn)
            Toast.makeText(this, "Regresando al inicio", Toast.LENGTH_SHORT).show()
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
    private fun getPersonajes(): MutableList<Personaje> {
        var personajes : MutableList<Personaje> = ArrayList()

        personajes.add(Personaje(R.drawable.yoda, "Yoda", "Piscis", R.string.yodaa))
        personajes.add(Personaje(R.drawable.hansolo, "Han solo", "Acuario", R.string.hansolo))
        personajes.add(Personaje(R.drawable.arturo, "Arturo", "Capricornio", R.string.arturo))
        personajes.add(Personaje(R.drawable.jabba, "Jabba", "Sagitario", R.string.jabba))
        var bdd = AppDataBase.getDataBase(this)
        personajes.addAll(bdd.personajeDao().getall())
        return personajes
    }
}