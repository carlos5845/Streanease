package com.miaplicaion.mycard

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.miaplicaion.mycard.data.model.Card
import com.miaplicaion.mycard.data.model.CardManager

class pantalla5 : AppCompatActivity() {

    private lateinit var informacionLayout: LinearLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla5)

        // Ajustar insets para la vista principal
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val principal = findViewById<ImageView>(R.id.principal)
        principal.setOnClickListener {
            val intent = Intent(this, pantalla5::class.java)
            startActivity(intent)
        }
        val confi = findViewById<ImageView>(R.id.confi)
        confi.setOnClickListener {
            val intent = Intent(this, pantalla8::class.java)
            startActivity(intent)
        }
        val notitif = findViewById<ImageView>(R.id.notiti)
        notitif.setOnClickListener {
            val intent = Intent(this, pantalla7::class.java)
            startActivity(intent)
        }

        // Encuentra el CardView por su ID
        val cardView3 = findViewById<CardView>(R.id.cardView3)

        // Configura el OnClickListener
        cardView3.setOnClickListener {
            val intent = Intent(this, pantalla6::class.java)
            startActivity(intent)
        }

        informacionLayout = findViewById(R.id.informacion)

        // Recibir el Intent con la instancia de Card
        val card = intent.getParcelableExtra<Card>("card")
        card?.let {
            CardManager.addCard(it)
        }

        // Mostrar todas las tarjetas
        displayAllCards()

        // Configurar los OnClickListener para los botones segui y prox
        val seguiButton = findViewById<ImageView>(R.id.segui)
        seguiButton.setOnClickListener {
            showMessage("Usted no tiene nada que compartir")
        }

        val proxButton = findViewById<ImageView>(R.id.prox)
        proxButton.setOnClickListener {
            showMessage("Usted no tiene nada que compartir")
        }
    }

    private fun displayAllCards() {
        // Limpiar el contenido actual
        informacionLayout.removeAllViews()

        // Inflar y agregar un TextView para cada tarjeta en la lista
        for (card in CardManager.cards) {
            addCardInfo(card)
        }
    }

    private fun addCardInfo(card: Card) {
        // Inflar el layout personalizado
        val inflater = LayoutInflater.from(this)
        val cardView = inflater.inflate(R.layout.item_card, informacionLayout, false)

        // Configurar los datos de la tarjeta en el layout inflado
        cardView.findViewById<TextView>(R.id.textViewName).text = " ${card.name}"
        cardView.findViewById<TextView>(R.id.textViewAmount).text = " ${card.amount}.00"
        cardView.findViewById<TextView>(R.id.textViewDescription).text = "Descripcion: ${card.description}"
        cardView.findViewById<TextView>(R.id.textViewDueDate).text = "Fecha de Vencimiento: ${card.dueDate}"
        cardView.findViewById<TextView>(R.id.textViewPaymentMethod).text = "Metodo de Pago: ${card.paymentMethod}"

        val extraInfoLayout = cardView.findViewById<LinearLayout>(R.id.extraInfoLayout)

        // Configurar el OnClickListener para expandir o colapsar la información adicional
        cardView.setOnClickListener {
            if (extraInfoLayout.visibility == View.GONE) {
                extraInfoLayout.visibility = View.VISIBLE
            } else {
                extraInfoLayout.visibility = View.GONE
            }
        }

        // Agregar el nuevo cardView al LinearLayout dentro del ScrollView
        informacionLayout.addView(cardView)
    }

    private fun showMessage(message: String) {
        // Inflar el layout del mensaje
        val inflater = LayoutInflater.from(this)
        val view = inflater.inflate(R.layout.dialog_message, null)

        // Configurar el mensaje y el botón de cerrar
        val messageTextView = view.findViewById<TextView>(R.id.messageTextView)
        messageTextView.text = message

        val closeButton = view.findViewById<Button>(R.id.closeButton)
        val dialog = AlertDialog.Builder(this)
            .setView(view)
            .create()

        closeButton.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}
