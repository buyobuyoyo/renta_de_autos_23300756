package com.example.renta_de_autos_23300756

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.content.Intent
import android.view.Menu
import android.view.MenuItem

class activity_registrar_cliente : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_cliente)

        val toolbar = findViewById<Toolbar>(R.id.app_toolbar)
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_desplegable, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_pantalla_inicio -> startActivity(Intent(this, MainActivity::class.java))
            R.id.action_registrar_vehiculo -> startActivity(Intent(this, activity_registrar_vehiculo::class.java))
            R.id.action_registrar_cliente -> startActivity(Intent(this, activity_registrar_cliente::class.java))
            R.id.action_rentar_vehiculo -> startActivity(Intent(this, activity_rentar_vehiculo::class.java))
            R.id.action_devolver_vehiculo -> startActivity(Intent(this, activity_devolver_vehiculo::class.java))
            R.id.action_consultar_vehiculos -> startActivity(Intent(this, activity_consulta_vehiculo::class.java))
            R.id.action_consultar_rentas -> startActivity(Intent(this, activity_consultar_renta::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
}