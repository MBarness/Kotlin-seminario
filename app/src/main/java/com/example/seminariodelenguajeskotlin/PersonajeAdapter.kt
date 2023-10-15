package com.example.seminariodelenguajeskotlin
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonajeAdapter(private val context: Context, private val personajes: List<Personaje>) : RecyclerView.Adapter<PersonajeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_personaje, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val personaje = personajes[position]
        holder.bind(personaje)
    }

    override fun getItemCount(): Int {
        return personajes.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nombrePersonaje: TextView = itemView.findViewById(R.id.nombrePersonaje)
        private val signoPersonaje: TextView = itemView.findViewById(R.id.signoPersonaje)
        private val relacionSignoPersonaje: TextView = itemView.findViewById(R.id.relacionSignoPersonaje)
        private val itemImageView: ImageView = itemView.findViewById(R.id.itemImageView)

        fun bind(personaje: Personaje) {
            nombrePersonaje.text = personaje.personaje
            signoPersonaje.text = personaje.signoZ
            relacionSignoPersonaje.text = context.getString(personaje.relacion)
            itemImageView.setImageResource(personaje.imagen)
        }
    }
}
