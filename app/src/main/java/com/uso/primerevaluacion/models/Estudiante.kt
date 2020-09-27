package com.uso.primerevaluacion.models

class Estudiante(
    var nombre: String,
    var codigo: String,
    var materia: String,
    var parcial1: Double,
    var parcial2: Double,
    var parcial3: Double
) {
    var promedio: Double = 0.0
        get(){
            return (parcial1*0.3) + (parcial2*0.3) + (parcial3*0.4)
        }
}