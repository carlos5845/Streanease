package com.miaplicaion.mycard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class pantalla8 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla8)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Encontrar el botón por su ID y establecer el OnClickListener
        val principalButton = findViewById<ImageView>(R.id.principal)
        principalButton.setOnClickListener {
            val intent = Intent(this, pantalla5::class.java)
            startActivity(intent)
        }

        val proxButton = findViewById<ImageView>(R.id.prox)
        proxButton.setOnClickListener {
            showMessageDialog("Usted no tiene nada que compartir.")
        }

        val seguiButton = findViewById<ImageView>(R.id.segui)
        seguiButton.setOnClickListener {
            showMessageDialog("Usted no tiene nada que compartir.")
        }

        val expandOptionsButton = findViewById<ImageView>(R.id.expand_options)
        expandOptionsButton.setOnClickListener {
            showMessageDialog("aqui no hay nada")
        }

        val expandOptionsButton2 = findViewById<ImageView>(R.id.expand_options2)
        expandOptionsButton2.setOnClickListener {
            showMessageDialog("aqui no hay nada")
        }

        val expandOptionsButton3 = findViewById<ImageView>(R.id.expand_options3)
        expandOptionsButton3.setOnClickListener {
            showMessageDialog("aqui no hay nada")
        }

        val expandOptionsButton4 = findViewById<ImageView>(R.id.expand_options4)
        expandOptionsButton4.setOnClickListener {
            showMessageDialog("aqui no hay nada")
        }
    }

    private fun showMessageDialog(message: String) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_message, null)
        val messageTextView = dialogView.findViewById<TextView>(R.id.messageTextView)
        val closeButton = dialogView.findViewById<Button>(R.id.closeButton)

        messageTextView.text = message

        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        closeButton.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}
