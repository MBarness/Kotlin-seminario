package com.example.seminariodelenguajeskotlin

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.app.NotificationCompat
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

            showNotification()

            val intent = Intent(this, LogInActivity::class.java)
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
        }

        return super.onOptionsItemSelected(item)
    }

    fun showNotification() {
        val channelId = getString(R.string.notification_channel_id)

        // Crear una notificación
        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.intro)
            .setContentTitle("Star Wars")
            .setContentText("Se a registrado correctamente.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        // Obtener el NotificationManager
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Si estás utilizando canales de notificación, debes crear el canal antes de mostrar la notificación
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.notification_channel_name)
            val description = getString(R.string.notification_channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, name, importance).apply {
                this.description = description
            }
            notificationManager.createNotificationChannel(channel)
        }
        val notificationId = 1
        // Mostrar la notificación
        notificationManager.notify(notificationId, notificationBuilder.build())
    }

}

