package com.example.renta_de_autos_23300756

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ConsultarVehiculosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consulta_vehiculo)

        val datosVehiculos = listOf(
            Vehiculo("Toyota Corolla", "JLM-4421", "Disponible"),
            Vehiculo("Suzuki Swift", "PXR-8812", "En renta"),
            Vehiculo("Nissan Versa", "ABC-9011", "Disponible"),
            Vehiculo("Chevrolet Onix", "XYZ-3320", "Mantenimiento")
        )


        val rvLista = findViewById<RecyclerView>(R.id.rvListaVehiculos)

        rvLista.layoutManager = LinearLayoutManager(this)

        rvLista.adapter = VehiculoAdapter(datosVehiculos)
    }
}