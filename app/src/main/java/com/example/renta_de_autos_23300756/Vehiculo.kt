package com.example.renta_de_autos_23300756

data class Vehiculo(
    val placa: String,
    var marca: String,
    var modelo: String,
    var ano: Int,
    var costo: Double,
    private var disponible: Boolean = true
) {
    fun setDisponible(estado: Boolean) {
        disponible = estado
    }

    fun isDisponible(): Boolean = disponible
}