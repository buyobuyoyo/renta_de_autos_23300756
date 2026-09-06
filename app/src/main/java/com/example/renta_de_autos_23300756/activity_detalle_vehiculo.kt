package com.example.renta_de_autos_23300756

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class activity_detalle_vehiculo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_vehiculo)

        val pos = intent.getIntExtra("pos", -1)
        if (pos != -1 && pos < listaVehiculo.size) {
            val v = listaVehiculo[pos]
            findViewById<TextView>(R.id.tvPlaca).text = "Placa: ${v.placa}"
            findViewById<TextView>(R.id.tvMarca).text = "Marca: ${v.marca}"
            findViewById<TextView>(R.id.tvModelo).text = "Modelo: ${v.modelo}"
            findViewById<TextView>(R.id.tvAno).text = "Año: ${v.ano}"
            findViewById<TextView>(R.id.tvCosto).text = "Costo por día: $${v.costo}"
            findViewById<TextView>(R.id.tvDisponible).text = "Estado: ${if (v.isDisponible()) "Disponible" else "Rentado"}"
        }

        findViewById<Button>(R.id.btnVolver).setOnClickListener {
            finish()
        }
    }
}