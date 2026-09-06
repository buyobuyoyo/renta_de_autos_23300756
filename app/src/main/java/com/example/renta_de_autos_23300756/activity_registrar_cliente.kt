package com.example.renta_de_autos_23300756

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class activity_registrar_cliente : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_cliente)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val etIdentificacion = findViewById<EditText>(R.id.et_identificacion_cliente)
        val etNombre = findViewById<EditText>(R.id.et_nombre_cliente)
        val etTelefono = findViewById<EditText>(R.id.et_telefono_cliente)
        val btnGuardar = findViewById<Button>(R.id.btn_guardar_cliente)

        btnGuardar.setOnClickListener {
            val id = etIdentificacion.text.toString().trim()
            val nombreCompleto = etNombre.text.toString().trim()
            val telefono = etTelefono.text.toString().trim()

            if (id.isNotEmpty() && nombreCompleto.isNotEmpty() && telefono.isNotEmpty()) {
                val cliente = Cliente(id, nombreCompleto, "", telefono)
                listaCliente.add(cliente)
                Toast.makeText(this, "Cliente registrado exitosamente", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Por favor llene todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}