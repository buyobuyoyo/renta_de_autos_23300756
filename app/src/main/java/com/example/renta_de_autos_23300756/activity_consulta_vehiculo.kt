package com.example.renta_de_autos_23300756

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class activity_consulta_vehiculo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consulta_vehiculo)



        val rvLista = findViewById<RecyclerView>(R.id.rvListaVehiculos)

        rvLista.layoutManager = LinearLayoutManager(this)

        rvLista.adapter = VehiculoAdapter(listaVehiculo)
    }
}