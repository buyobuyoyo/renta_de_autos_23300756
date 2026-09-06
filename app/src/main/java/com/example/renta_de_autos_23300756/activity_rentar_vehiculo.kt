package com.example.renta_de_autos_23300756

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class activity_rentar_vehiculo : AppCompatActivity() {

    private var vehiculosDisponibles: List<Vehiculo> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rentar_vehiculo)

        val toolbar = findViewById<Toolbar>(R.id.app_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val etIdCliente = findViewById<EditText>(R.id.et_id_cliente_renta)
        val spVehiculos = findViewById<Spinner>(R.id.sp_vehiculos_disponibles)
        val etDias = findViewById<EditText>(R.id.et_dias_renta)
        val btnConfirmar = findViewById<Button>(R.id.btn_confirmar_renta)

        // Filtrar vehículos disponibles
        vehiculosDisponibles = listaVehiculo.filter { it.isDisponible() }
        val nombresAutos = vehiculosDisponibles.map { "${it.marca} ${it.modelo} (${it.placa})" }

        spVehiculos.adapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_dropdown_item, nombresAutos
        )

        btnConfirmar.setOnClickListener {
            val idCliente = etIdCliente.text.toString().trim()
            val dias = etDias.text.toString().toIntOrNull() ?: 0

            val clienteEncontrado = listaCliente.find { it.identificacion == idCliente }

            if (clienteEncontrado == null) {
                Toast.makeText(this, "Cliente no registrado. Verifique el ID", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (vehiculosDisponibles.isEmpty()) {
                Toast.makeText(this, "No hay vehículos disponibles", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (dias <= 0) {
                Toast.makeText(this, "Ingrese una cantidad válida de días", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val vehiculoSeleccionado = vehiculosDisponibles[spVehiculos.selectedItemPosition]
            val nuevoIdRenta = (listaRenta.size + 1).toString()

            val nuevaRenta = Renta(nuevoIdRenta, clienteEncontrado, vehiculoSeleccionado, dias)
            vehiculoSeleccionado.setDisponible(false)
            listaRenta.add(nuevaRenta)

            Toast.makeText(this, "Renta #${nuevoIdRenta} realizada con éxito", Toast.LENGTH_SHORT).show()
            finish()
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