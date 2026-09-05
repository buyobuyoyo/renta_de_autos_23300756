package com.example.renta_de_autos_23300756

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VehiculoAdapter(private val listaVehiculos: List<Vehiculo>) :
    RecyclerView.Adapter<VehiculoAdapter.VehiculoViewHolder>() {

    class VehiculoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombre: TextView = itemView.findViewById(R.id.tvItemNombreVehiculo)
        val tvPlaca: TextView = itemView.findViewById(R.id.tvItemPlaca)
        val tvEstado: TextView = itemView.findViewById(R.id.tvItemEstado)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehiculoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_vehiculo, parent, false)
        return VehiculoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VehiculoViewHolder, position: Int) {
        val vehiculo = listaVehiculos[position]

        holder.tvNombre.text = "Vehículo: ${vehiculo.marca} ${vehiculo.modelo}"
        holder.tvPlaca.text = "Placa: ${vehiculo.placa}"

        val estadoTexto = if (vehiculo.isDisponible()) "Disponible" else "No disponible"
        holder.tvEstado.text = "Estado: $estadoTexto"
    }

    override fun getItemCount(): Int = listaVehiculos.size
}