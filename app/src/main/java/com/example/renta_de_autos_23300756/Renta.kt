package com.example.renta_de_autos_23300756

data class Renta(
    val idRenta: String,
   /* val cliente: Cliente, */
    val vehiculo: Vehiculo,
    var dias: Int,
    var activa: Boolean = true
) {
    var costoTotal: Double = 0.0
        private set

    init {
        calcularCostoTotal()
    }

    fun calcularCostoTotal(): Double {
        costoTotal = dias * vehiculo.costo
        return costoTotal
    }

    fun finalizarRenta() {
        activa = false
        vehiculo.setDisponible(true)
    }
}