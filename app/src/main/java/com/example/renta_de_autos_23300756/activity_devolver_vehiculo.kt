package com.example.renta_de_autos_23300756

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class activity_devolver_vehiculo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_devolver_vehiculo)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val etIdRenta = findViewById<EditText>(R.id.et_id_renta)
        val etPlaca = findViewById<EditText>(R.id.et_placa_devolucion)
        val btnDevolver = findViewById<Button>(R.id.btn_confirmar_devolucion)

        btnDevolver.setOnClickListener {
            val idRenta = etIdRenta.text.toString().trim()
            val placa = etPlaca.text.toString().trim()

            // Buscar la renta activa por ID o por Placa
            val renta = listaRenta.find { it.activa && (it.idRenta == idRenta || it.vehiculo.placa.equals(placa, ignoreCase = true)) }

            if (renta != null) {
                renta.finalizarRenta()
                Toast.makeText(this, "Vehículo devuelto con éxito", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "No se encontró una renta activa con esos datos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}