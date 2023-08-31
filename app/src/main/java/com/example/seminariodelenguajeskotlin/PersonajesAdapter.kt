package com.example.seminariodelenguajeskotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class PersonajesAdapter(var personajes: MutableList<Personaje>, var context : Context):
    RecyclerView.Adapter<PersonajesAdapter.PersonajeViewHolder>() {


    override fun onBindViewHolder(holder: PersonajeViewHolder, position: Int) {
        val item = personajes.get(position)
        holder.imaPeronaje = item.imagen
        holder.txtNombre.text = item.personaje
        holder.txtSignoZ.text = item.signoZ
        holder.textRealcion.text = item.relacion
        Toast.makeText(context, item.personaje, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_personaje, parent, false)
        return PersonajeViewHolder(view)
    }
    override fun getItemCount() = personajes.size

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

}