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
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import java.util.Date


class RegistrarActivity : AppCompatActivity() {
    lateinit var toolbar: Toolbar
    lateinit var eNombre : EditText
    lateinit var  eContra : EditText
    lateinit var bGuardar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        toolbar = findViewById(R.id.toolBar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Registro de usuario"

        eNombre = findViewById(R.id.editNombre)
        eContra = findViewById(R.id.editContraseña)
        bGuardar = findViewById(R.id.bottonGuardarInf)

        bGuardar.setOnClickListener{

            val intent = Intent(this, LogInActivity::class.java)

            var nombre = eNombre.text.toString()
            var contra = eContra.text.toString()
            if (nombre.isEmpty() && contra.isEmpty()){
                Toast.makeText(this, "Faltan completar datos", Toast.LENGTH_SHORT).show()
            }else{
                //se crea nuevo usuario con el constructor de la data class
                var nuevoUsuario = Usuario(nombre,contra)
                //se llama a la base con el dao q invoca la instruccion de insert q va automatic a la base
                AppUsersDataBase.getUserDatabase(this).usuarioDao.insertUsuario(nuevoUsuario)
            }
            var preferencias = getSharedPreferences(resources.getString(R.string.sp_credenciales), MODE_PRIVATE)
            preferencias.edit().putString(resources.getString(R.string.nombre_usuario), nombre).apply()
            preferencias.edit().putString(resources.getString(R.string.contraseña), contra).apply()
            startActivity(intent)
        }
    }
    //invocas el menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //formato del menu, las opciones
        menuInflater.inflate(R.menu.menu_main , menu)
        return super.onCreateOptionsMenu(menu)
    }

    // con un if, segun el id tocado te manda a esa pagina/activity
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.backButton){
            val intentLogIn = Intent(this, LogInActivity::class.java)
            startActivity(intentLogIn)
            Toast.makeText(this, "Regresando", Toast.LENGTH_SHORT).show()
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}

