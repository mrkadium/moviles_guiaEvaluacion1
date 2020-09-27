package com.uso.primerevaluacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.uso.primerevaluacion.models.Estudiante

class MainActivity : AppCompatActivity() {
    lateinit var buttonForm: Button
    lateinit var buttonLista: Button
    companion object Global{
        var listEstudiantes: MutableList<Estudiante> = mutableListOf()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonForm = findViewById(R.id.buttonForm)
        buttonLista = findViewById(R.id.buttonLista)

        buttonForm.setOnClickListener {
            var intent = Intent(this, FormularioActivity::class.java)
            startActivity(intent)
        }

        buttonLista.setOnClickListener {
            if(listEstudiantes.size == 0 ) Toast.makeText(this, "Aún no hay ningún registro", Toast.LENGTH_SHORT).show()
            else {
                var intent = Intent(this, ListaActivity::class.java)
                startActivity(intent)
            }
        }
    }
}