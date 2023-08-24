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


       //funcion q escucha si el boton se apreto o no
        crearU.setOnClickListener {
            //escribe mensaje en la pantalla
            Toast.makeText(this, "Registrar Usuario", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, RegistrarActivity::class.java) // crea el Intent
            startActivity(intent) // inicia la actividad con el Intent
        }


        iniciarS.setOnClickListener {
            //lo q se puso en edir lo castea a texto y string y pregunta si esta vacio
            if (eContra.text.toString().isEmpty() || eUsuario.text.toString().isEmpty()) {
                Toast.makeText(this, "Falta el usuario o contraseña", Toast.LENGTH_SHORT).show()
            } else {
                //si el check box fue marcado
                if (check.isChecked) {
                    Toast.makeText(this, "Recordar Usuario", Toast.LENGTH_SHORT).show()
                }

                //envia las credenciales al loginactivity
                    val bundle = intent.getBundleExtra("datos")
                    val nombre = bundle?.getString("nombre")
                    val apellido = bundle?.getString("apellido")
                    val contra = bundle?.getString("contra")


                //verifica que coincidan las credenciales con las tipeadas
                if(eUsuario.text.toString() == nombre && eContra.text.toString() == contra){
                    //mandar al main de la pagina donde este la lista o lo q hay q hacer

                    var intentMain = Intent(this, MainActivity::class.java)
                    intentMain.putExtra("nombre", nombre)
                    intentMain.putExtra("apellido", apellido)
                    Toast.makeText(this, "Bienvenido $nombre $apellido", Toast.LENGTH_SHORT).show()
                    startActivity(intentMain)

                }else{
                    Toast.makeText(this, "Usuario o contraseña no validos, registrarse por favor", Toast.LENGTH_LONG).show()
                }

            }

        }
    }

}
