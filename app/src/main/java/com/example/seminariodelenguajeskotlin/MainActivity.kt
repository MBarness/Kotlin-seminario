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



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = listOf("Aries", "Tauro", "Piscis", "Géminis", "Cáncer", "Leo", "Virgo", "Libra", "Escorpio", "Sagitario", "Capricornio", "Acuario")
        val autoComplete:AutoCompleteTextView=findViewById(R.id.auto_complete_txt)
        val adapter = ArrayAdapter(this, R.layout.list_item, items)
        autoComplete.setAdapter(adapter)
        autoComplete.onItemClickListener= AdapterView.OnItemClickListener {
                adapterView, view, i, l ->
            val itemSelected = adapterView.getItemAtPosition(i)
            Toast.makeText(this, "Signo: $itemSelected", Toast.LENGTH_SHORT).show()


        }



//api
        val api = RetroFitClient.retrofit.create(MyApi::class.java)
        val callGetPost = api.getPost()
        callGetPost.enqueue(object : retrofit2.Callback<List<Post>>
        {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val posts = response.body()
                if (posts != null){
                    tvServicioRest = findViewById(R.id.tvServicioRest)
                    tvServicioRest.text = posts.toString()
                    Log.d("Response", posts.toString())
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.e("Error", t.message?:"")
            } })


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