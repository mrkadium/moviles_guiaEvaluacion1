package com.uso.primerevaluacion.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uso.primerevaluacion.R
import com.uso.primerevaluacion.models.Estudiante
import com.uso.primerevaluacion.viewholders.ViewHolderEstudiante

class EstudianteAdapter(var data: List<Estudiante>) : RecyclerView.Adapter<ViewHolderEstudiante>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderEstudiante {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_estudiante, parent, false)
        return ViewHolderEstudiante(view)
    }

    override fun onBindViewHolder(holder: ViewHolderEstudiante, position: Int) {
        holder.indice.text = (position.plus(1)).toString()
        holder.nombre.text = data[position].nombre
        holder.codigo.text = data[position].codigo
        holder.materia.text = data[position].materia.plus(": ")
        holder.promedio.text = data[position].promedio.toString()
    }

    override fun getItemCount(): Int {
        return data.size
    }
}