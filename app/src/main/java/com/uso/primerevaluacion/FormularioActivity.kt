package com.uso.primerevaluacion

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.uso.primerevaluacion.models.Estudiante

class FormularioActivity : AppCompatActivity() {
    lateinit var editNombre: EditText
    lateinit var editCodigo: EditText
    lateinit var editMateria: EditText
    lateinit var editParcial1: EditText
    lateinit var editParcial2: EditText
    lateinit var editParcial3: EditText
    lateinit var buttonGuardar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        editNombre = findViewById(R.id.editNombre)
        editCodigo = findViewById(R.id.editCodigo)
        editMateria = findViewById(R.id.editMateria)
        editParcial1 = findViewById(R.id.editParcial1)
        editParcial2 = findViewById(R.id.editParcial2)
        editParcial3 = findViewById(R.id.editParcial3)
        buttonGuardar = findViewById(R.id.buttonGuardar)

        buttonGuardar.setOnClickListener{
            saveData()
        }
    }

    override fun onBackPressed(){
        if(makeSureBack()) super.onBackPressed()
        else showDialog()
    }

    /**
     * If all of the edit text are empty, then allow back
     * Else it's going to ask if it's ok to go back
     */
    private fun makeSureBack(): Boolean{
        return editNombre.text.isEmpty() && editCodigo.text.isEmpty() && editMateria.text.isEmpty() && editParcial1.text.isEmpty()
    }

    private fun saveData(){
        if(editNombre.text.isNotEmpty() && editCodigo.text.isNotEmpty() && editMateria.text.isNotEmpty() &&
            editParcial1.text.isNotEmpty() && editParcial2.text.isNotEmpty() && editParcial3.text.isNotEmpty()){

            val e: Estudiante = Estudiante(
                editNombre.text.toString(),
                editCodigo.text.toString(),
                editMateria.text.toString(),
                editParcial1.text.toString().toDouble(),
                editParcial2.text.toString().toDouble(),
                editParcial3.text.toString().toDouble()
            )
            MainActivity.listEstudiantes.add(e)

            Toast.makeText(this, "Registro guardado correctamente", Toast.LENGTH_SHORT).show()
            finish()

        }else{
            if(editNombre.text.isEmpty()) editNombre.setError("Debe llenar este campo")
            if(editCodigo.text.isEmpty()) editCodigo.setError("Debe llenar este campo")
            if(editMateria.text.isEmpty()) editMateria.setError("Debe llenar este campo")
            if(editParcial1.text.isEmpty()) editParcial1.setError("Debe llenar este campo")
            if(editParcial2.text.isEmpty()) editParcial2.setError("Debe llenar este campo")
            if(editParcial3.text.isEmpty()) editParcial3.setError("Debe llenar este campo")

            Toast.makeText(this, "Debe llenar todos los campos para guardar", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showDialog(){

        val builder: AlertDialog.Builder? = this?.let {
            AlertDialog.Builder(it)
        }

        builder?.setMessage(R.string.dialog_message)
            ?.setTitle(R.string.dialog_title)

        builder?.apply {
            setPositiveButton(R.string.ok,
                DialogInterface.OnClickListener { dialog, id ->
                    finish()
                })
            setNegativeButton(R.string.cancel,
                DialogInterface.OnClickListener { dialog, id ->

                })
        }

        val dialog: AlertDialog? = builder?.create()

        builder?.show()
    }
}