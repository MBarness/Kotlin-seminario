package com.example.seminariodelenguajeskotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class LogInActivity : AppCompatActivity() {

    lateinit var eUsuario : EditText
    lateinit var eContra : EditText
    lateinit var crearU: Button
    lateinit var iniciarS: Button
    lateinit var check: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //vincular variable con id correspondiente
        eUsuario = findViewById(R.id.editUsuario)
        eContra = findViewById(R.id.editContraseña)
        iniciarS = findViewById(R.id.bottonIniciarS)
        crearU = findViewById(R.id.bottonCrearU)
        check = findViewById(R.id.checkBox)



        //trae los datos guardados de la base(creo), si es que hay
        var preferencias = getSharedPreferences(resources.getString(R.string.sp_credenciales), MODE_PRIVATE)
        //de la base toma el nombre del usuario y contraseña
        var nombreUsuario = preferencias.getString(resources.getString(R.string.nombre_usuario), "")
        var contraseña = preferencias.getString(resources.getString(R.string.contraseña), "")
/*
            SI SE DESCOMENTA ESTO NO SE PUEDE CERRAR SESION, Y SIEMPRE Q SE COMPILE TE VA A MANDAR AL MAIN
        //si los datos q trae de la base coinciden con los escritos entra
        if(nombreUsuario !=null && contraseña !=null){
            startMainActivity(nombreUsuario)
        }
*/
        //funcion q escucha si el boton se apreto o no
        crearU.setOnClickListener {
            //escribe mensaje en la pantalla
            Toast.makeText(this, "Registrar Usuario", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, RegistrarActivity::class.java) // crea el Intent
            startActivity(intent) // inicia la actividad con el Intent
            finish()
        }


        iniciarS.setOnClickListener {

            var usuario = eUsuario.text.toString()
            var contra = eContra.text.toString()

            //lo q se puso en edir lo castea a texto y string y pregunta si esta vacio
            if (contra.isEmpty() || usuario.isEmpty()) {
                Toast.makeText(this, "Falta el usuario o contraseña", Toast.LENGTH_SHORT).show()
            } else {

                //trae los datos guardados de la base(creo), si es que hay
                var preferencias = getSharedPreferences(resources.getString(R.string.sp_credenciales), MODE_PRIVATE)
                //de la base toma el nombre del usuario y contraseña
                var nombreUsuario = preferencias.getString(resources.getString(R.string.nombre_usuario), "")
                var contraseña = preferencias.getString(resources.getString(R.string.contraseña), "")

                //si los datos q trae de la base coinciden con los escritos entra
                if(nombreUsuario == usuario && contraseña == contra){
                    if (check.isChecked) {
                        Toast.makeText(this, "Recordar Usuario", Toast.LENGTH_SHORT).show()
                        var pref = getSharedPreferences(resources.getString(R.string.sp_credenciales), MODE_PRIVATE)
                        preferencias.edit().putString(resources.getString(R.string.nombre_usuario), usuario).apply()
                        preferencias.edit().putString(resources.getString(R.string.contraseña), contra).apply()
                    }
                    startMainActivity(nombreUsuario)
                } else{
                    Toast.makeText(this, "Usuario o contraseña no validos, registrarse por favor", Toast.LENGTH_LONG).show()
                }

                //si el check box fue marcado se acuerda los datos y si esos datos ya excistian / a chequear como hacer
            }

        }
    }

    private fun startMainActivity(usuario: String) {
        var intentMain = Intent(this, MainActivity::class.java)
        intentMain.putExtra(resources.getString(R.string.nombre_usuario), usuario)
        startActivity(intentMain)
        finish()
    }

}
