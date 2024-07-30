package com.miaplicaion.mycard

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView // Importar ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class pantalla8 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla8)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Encontrar el botón por su ID y establecer el OnClickListener
        val principalButton = findViewById<ImageView>(R.id.principal)
        principalButton.setOnClickListener {
            // Crear una intención para navegar a la pantalla5
            val intent = Intent(this, pantalla5::class.java)
            startActivity(intent)
        }
    }
}
