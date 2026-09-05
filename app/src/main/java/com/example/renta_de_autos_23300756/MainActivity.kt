package com.example.renta_de_autos_23300756
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Encuentra tu Toolbar incluida y establécela como ActionBar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Oculta el título por defecto si ya pusiste tu propio TextView con "Carrazos"
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    // 1. Dibuja los 3 puntos y carga el menú
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_desplegable, menu)
        return true
    }

    // 2. Escucha a cuál opción le dieron clic
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_registrar_vehiculo -> {
                Toast.makeText(this, "Registrar vehículo", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_registrar_cliente -> {
                Toast.makeText(this, "Registrar cliente", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_rentar_vehiculo -> {
                Toast.makeText(this, "Rentar vehículo", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_devolver_vehiculo -> {
                Toast.makeText(this, "Devolver vehículo", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_consultar_vehiculos -> {
                Toast.makeText(this, "Consultar vehículos", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_consultar_rentas -> {
                Toast.makeText(this, "Consultar rentas", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}