package com.example.renta_de_autos_23300756

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RentaAdapter(private val listaRentas: List<Renta>) :
    RecyclerView.Adapter<RentaAdapter.RentaViewHolder>() {

    class RentaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombreVehiculo: TextView = itemView.findViewById(R.id.tvItemNombreVehiculo)
        val tvPlaca: TextView = itemView.findViewById(R.id.tvItemPlaca)
        val tvDias: TextView = itemView.findViewById(R.id.tvItemDias)
        val tvCosto: TextView = itemView.findViewById(R.id.tvItemCosto)
        val tvCliente: TextView = itemView.findViewById(R.id.tvItemCliente)
        val tvEstado: TextView = itemView.findViewById(R.id.tvItemEstado)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RentaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_renta, parent, false)
        return RentaViewHolder(view)
    }

    override fun onBindViewHolder(holder: RentaViewHolder, position: Int) {
        val renta = listaRentas[position]

        holder.tvNombreVehiculo.text = "Renta: #${renta.idRenta} - ${renta.vehiculo.marca} ${renta.vehiculo.modelo}"
        holder.tvPlaca.text = "Placa: ${renta.vehiculo.placa}"
        holder.tvDias.text = "Días: ${renta.dias}"
        holder.tvCosto.text = "Costo: $${renta.costoTotal}"
        val estadoTexto = if (renta.activa) "Activa" else "Finalizada"
        holder.tvEstado.text = "Estado: $estadoTexto"
    }

    override fun getItemCount(): Int = listaRentas.size
}