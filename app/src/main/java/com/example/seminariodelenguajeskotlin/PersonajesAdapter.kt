package com.example.seminariodelenguajeskotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

//adaptor personalizado, para mostrar cada elemento en la lista
class PersonajesAdapter(var personajes: MutableList<Personaje>, var context : Context):
    RecyclerView.Adapter<PersonajesAdapter.PersonajeViewHolder>() {

    //muestra una posicion especifica de la lista (holder = vista individual)
    override fun onBindViewHolder(holder: PersonajeViewHolder, position: Int) {
        //A esta posicion de la lista, se le asignan valores,
        val item = personajes.get(position)

        //caso particular par amostrar imagenes en la lista
        holder.imaPeronaje.setImageResource(item.imagen)

        holder.txtNombre.text = item.personaje
        holder.txtSignoZ.text = item.signoZ
        holder.textRealcion.text = item.relacion
        Toast.makeText(context, item.personaje, Toast.LENGTH_SHORT).show()
    }

    //esta funcion crea la vista holder, desde la clase item_personaje
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_personaje, parent, false)
        return PersonajeViewHolder(view)
    }

    //cantidad total de elementos de la lista
    override fun getItemCount() = personajes.size

    //obtiene las referencias de cada vista
    class PersonajeViewHolder(view:View): RecyclerView.ViewHolder(view) {
        var imaPeronaje: ImageView
        var txtNombre : TextView
        var txtSignoZ : TextView
        var textRealcion : TextView
         init {
             imaPeronaje= view.findViewById(R.id.itemImageView)
             txtNombre= view.findViewById(R.id.nombrePersonaje)
             txtSignoZ= view.findViewById(R.id.signoPersonaje)
             textRealcion= view.findViewById(R.id.relacionSignoPersonaje)

         }
    }
    //1) getItemCount = trae la cantidad de items
   //2)class PersonajeViewHolder(view:View) = trae las referencias de cada vista
    //3) onCreateViewHolder = crea cada estructura de cada item
    //4) onBindViewHolder = con la estructura creada y sus valores va cargando cada posicion
}