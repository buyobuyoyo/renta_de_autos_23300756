package com.example.renta_de_autos_23300756

import android.os.Bundle
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

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
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
}