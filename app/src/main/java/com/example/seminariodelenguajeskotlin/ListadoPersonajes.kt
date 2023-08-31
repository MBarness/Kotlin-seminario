package com.example.seminariodelenguajeskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
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

    private fun getPersonajes(): MutableList<Personaje> {
        var personajes : MutableList<Personaje> = ArrayList()

        personajes.add(Personaje(1, R.drawable.yoda, "Yoda", "Piscis", "relacion" ))
        personajes.add(Personaje(2, R.drawable.hansolo, "Han solo", "Acuario", "relacion" ))
        personajes.add(Personaje(2, R.drawable.arturo, "Arturo", "capricornio", "relacion" ))
        personajes.add(Personaje(2, R.drawable.jabba, "Jabba", "Sagitario", "relacion" ))

        return personajes
    }
}