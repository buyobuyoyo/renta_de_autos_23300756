package com.example.renta_de_autos_23300756

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class activity_registrar_vehiculo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_vehiculo)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val etPlaca = findViewById<EditText>(R.id.et_placa)
        val spMarca = findViewById<Spinner>(R.id.sp_marca)
        val spTipo = findViewById<Spinner>(R.id.sp_tipo)
        val etModelo = findViewById<EditText>(R.id.et_modelo)
        val etAnio = findViewById<EditText>(R.id.et_anio)
        val etCosto = findViewById<EditText>(R.id.et_costo)
        val spDisponibilidad = findViewById<Spinner>(R.id.sp_disponibilidad)
        val btnGuardar = findViewById<Button>(R.id.btn_guardar_vehiculo)

        // Cargar datos a los Spinners desde strings.xml
        spMarca.adapter = ArrayAdapter.createFromResource(
            this, R.array.marcas_array, android.R.layout.simple_spinner_dropdown_item
        )
        spTipo.adapter = ArrayAdapter.createFromResource(
            this, R.array.tipos_array, android.R.layout.simple_spinner_dropdown_item
        )
        spDisponibilidad.adapter = ArrayAdapter.createFromResource(
            this, R.array.disponibilidad_array, android.R.layout.simple_spinner_dropdown_item
        )

        btnGuardar.setOnClickListener {
            val placa = etPlaca.text.toString().trim()
            val marca = spMarca.selectedItem.toString()
            val modelo = etModelo.text.toString().trim()
            val anio = etAnio.text.toString().toIntOrNull() ?: 0
            val costo = etCosto.text.toString().toDoubleOrNull() ?: 0.0
            val disponible = spDisponibilidad.selectedItemPosition == 0 // "Disponible"

            if (placa.isNotEmpty() && modelo.isNotEmpty() && anio > 1900 && costo > 0.0 && spMarca.selectedItemPosition > 0) {
                val nuevoVehiculo = Vehiculo(placa, marca, modelo, anio, costo, disponible)
                listaVehiculo.add(nuevoVehiculo)
                Toast.makeText(this, "Vehículo registrado con éxito", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Por favor complete todos los datos correctamente", Toast.LENGTH_SHORT).show()
            }
        }
    }
}