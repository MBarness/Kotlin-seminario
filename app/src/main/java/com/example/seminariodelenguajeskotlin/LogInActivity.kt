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

        var i = 0

       //funcion q escucha si el boton se apreto o no
        crearU.setOnClickListener {
            //escribe mensaje en la pantalla
            Toast.makeText(this, "Registrar Usuario", Toast.LENGTH_SHORT).show()
            Intent(this, RegistrarActivity::class.java)
             i = 1
        }


        iniciarS.setOnClickListener {
            var nombreUsuario = eUsuario.text.toString()
            //lo q se puso en edir lo castea a texto y string y pregunta si esta vacio
            if (eContra.text.toString().isEmpty() || eUsuario.text.toString().isEmpty()) {
                Toast.makeText(this, "Falta el usuario o contraseña", Toast.LENGTH_SHORT).show()
            } else {
                //si el check box fue marcado
                if (check.isChecked) {
                    Toast.makeText(this, "Recordar Usuario", Toast.LENGTH_SHORT).show()
                }

                var nom: String? = ""
                var ape: String? = ""
                var contra: String? = ""

                //para saber si entro al registrarse
                if (i==1) {
                    var bundle: Bundle? = intent.extras
                    if (bundle != null) {
                        nom = bundle?.getString("nombre")
                        ape = bundle?.getString("apellido")
                        contra = bundle?.getString("contraseña")
                    }
                }

                if(eUsuario.text.toString() == nom.toString() && eContra.text.toString()==contra.toString()){
                    //mandar al main de la pagina donde este la lista o lo q hay q hacer

                        var intentMain = Intent(this, MainActivity::class.java)
                        intentMain.putExtra("nombre", nom)
                        intentMain.putExtra("apellido", ape)

                }else{
                    Toast.makeText(this, "Usuario o contraseña no validos, registrarse por favor", Toast.LENGTH_LONG).show()
                }

                }
                finish()
            }
        }
    }
