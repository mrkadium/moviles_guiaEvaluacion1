package com.uso.primerevaluacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uso.primerevaluacion.adapters.EstudianteAdapter
import com.uso.primerevaluacion.models.Estudiante

class ListaActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: EstudianteAdapter
    lateinit var layout: LinearLayoutManager
    lateinit var listEstudiantes:MutableList<Estudiante>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        adapter = EstudianteAdapter(MainActivity.listEstudiantes)
        layout = LinearLayoutManager(this)
        recyclerView = findViewById(R.id.listEstudiantes)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = layout
        recyclerView.setHasFixedSize(true)
    }
}