package com.example.renta_de_autos_23300756

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import android.view.Menu
import android.view.MenuItem

class activity_consultar_renta : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar_renta)

        val toolbar = findViewById<Toolbar>(R.id.app_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val rv = findViewById<RecyclerView>(R.id.rvListaRentas)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = RentaAdapter(listaRenta)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_desplegable, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_pantalla_inicio -> startActivity(Intent(this, MainActivity::class.java))
            R.id.action_registrar_vehiculo -> startActivity(Intent(this, activity_registrar_vehiculo::class.java))
            R.id.action_registrar_cliente -> startActivity(Intent(this, activity_registrar_cliente::class.java))
            R.id.action_rentar_vehiculo -> startActivity(Intent(this, activity_rentar_vehiculo::class.java))
            R.id.action_devolver_vehiculo -> startActivity(Intent(this, activity_devolver_vehiculo::class.java))
            R.id.action_consultar_vehiculos -> startActivity(Intent(this, activity_consulta_vehiculo::class.java))
            R.id.action_consultar_rentas -> startActivity(Intent(this, activity_consultar_renta::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
}