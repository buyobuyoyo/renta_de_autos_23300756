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

class activity_devolver_vehiculo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_devolver_vehiculo)

        val toolbar = findViewById<Toolbar>(R.id.app_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val etIdRenta = findViewById<EditText>(R.id.et_id_renta)
        val etIdCliente = findViewById<EditText>(R.id.et_id_cliente_devolucion)
        val etPlaca = findViewById<EditText>(R.id.et_placa_devolucion)
        val btnDevolver = findViewById<Button>(R.id.btn_confirmar_devolucion)

        btnDevolver.setOnClickListener {
            val idRenta = etIdRenta.text.toString().trim()
            val idCliente = etIdCliente.text.toString().trim()
            val placa = etPlaca.text.toString().trim()

            // Hace falta el número de renta o la placa para identificar una renta concreta
            // (un mismo cliente puede tener varias rentas activas).
            if (idRenta.isEmpty() && placa.isEmpty()) {
                Toast.makeText(this, "Ingrese el número de renta o la placa del vehículo", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Todos los datos que se llenaron deben coincidir con la misma renta.
            val renta = listaRenta.find {
                it.activa &&
                    (idRenta.isEmpty() || it.idRenta == idRenta) &&
                    (idCliente.isEmpty() || it.cliente.identificacion == idCliente) &&
                    (placa.isEmpty() || it.vehiculo.placa.equals(placa, ignoreCase = true))
            }

            if (renta != null) {
                renta.finalizarRenta()
                Toast.makeText(this, "Vehículo devuelto con éxito", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "No se encontró una renta activa con esos datos", Toast.LENGTH_SHORT).show()
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