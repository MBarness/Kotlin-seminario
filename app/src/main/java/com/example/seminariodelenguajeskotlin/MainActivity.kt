package com.example.seminariodelenguajeskotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var tvServicioRest: TextView
    lateinit var toolbar: Toolbar
    val signos = mapOf(
        "Acuario" to 10, // Obi-Wan Kenobi
        "Piscis" to 20, // Yoda
        "Aries" to 5, // Luke Skywalker
        "Tauro" to 13, // Chewbacca
        "Géminis" to 30, // Kylo Ren
        "Cáncer" to 84, // Finn
        "Leo" to 14, // Han Solo
        "Virgo" to 85, // Jyn Erso
        "Libra" to 85, // Rey
        "Escorpio" to 4, // Darth Vader
        "Sagitario" to 36, // Jar-Jar Binks
        "Capricornio" to 5 // Princesa Leia
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = listOf("Aries", "Tauro", "Piscis", "Géminis", "Cáncer", "Leo", "Virgo", "Libra", "Escorpio", "Sagitario", "Capricornio", "Acuario")
        val autoComplete:AutoCompleteTextView=findViewById(R.id.auto_complete_txt)
        val adapter = ArrayAdapter(this, R.layout.list_item, items)
        autoComplete.setAdapter(adapter)
        autoComplete.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, view, i, l ->
            val itemSelected = adapterView.getItemAtPosition(i) as String // Obtenemos el signo elegido como un String

// Verificar si el signo existe en el mapa
            if (signos.containsKey(itemSelected)) {
                Toast.makeText(this, "Signo: $itemSelected", Toast.LENGTH_SHORT).show()

                val id = signos[itemSelected] ?: 1 // Obtenemos el id del personaje asociado al signo o usamos 1 por defecto si no hay coincidencia
                val api = RetroFitClient.retrofit.create(MyApi::class.java) // Creamos la instancia de la interfaz de la API
                val callGetPost = api.getPost(id) // Hacemos la llamada a la API pasando el id como argumento
                callGetPost.enqueue(object : retrofit2.Callback<Post> { // Usamos un callback para obtener la respuesta de forma asíncrona
                    override fun onResponse(call: Call<Post>, response: Response<Post>) {
                        val post = response.body() // Obtenemos el objeto Post de la respuesta
                        if (post != null){
                            tvServicioRest = findViewById(R.id.tvServicioRest)
                            tvServicioRest.text = post.name // Mostramos el nombre del personaje en el TextView
                            Log.d("Response", post.toString())
                        }
                    }
                    override fun onFailure(call: Call<Post>, t: Throwable) {
                        Log.e("Error", t.message ?:" ")
                    }
                })
            } else {
                // Manejar el caso en el que el signo no existe en el mapa
                Toast.makeText(this, "Signo no válido: $itemSelected", Toast.LENGTH_SHORT).show()
            }
        }


        toolbar = findViewById(R.id.toolBar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = resources.getString(R.string.titulo)
        saudarUsuario()
    }
    private fun saudarUsuario() {

        val bundle : Bundle? = intent.extras
        if(bundle != null){
            val nombre = bundle.getString(resources.getString(R.string.nombre_usuario))
            Toast.makeText(this, "Bienvenido $nombre ", Toast.LENGTH_SHORT).show()
        }
    }
    //crea las opciones del menu, hacia donde podes ir
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //formato del menu, las opciones
        menuInflater.inflate(R.menu.menu_main , menu)
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