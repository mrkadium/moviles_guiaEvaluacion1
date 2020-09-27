package com.uso.primerevaluacion.viewholders

import android.view.View
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uso.primerevaluacion.R
import kotlinx.android.synthetic.main.item_estudiante.view.*

class ViewHolderEstudiante(view: View): RecyclerView.ViewHolder(view) {
    var indice:TextView = itemView.findViewById(R.id.indice)
    var nombre:TextView = itemView.findViewById(R.id.nombre)
    var codigo:TextView = itemView.findViewById(R.id.codigo)
    var materia:TextView = itemView.findViewById(R.id.materia)
    var promedio:TextView = itemView.findViewById(R.id.promedio)
}