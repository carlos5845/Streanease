package com.miaplicaion.mycard

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.miaplicaion.mycard.data.model.Card
import com.miaplicaion.mycard.data.model.CardManager
import java.util.*

class pantalla6 : AppCompatActivity() {

    private lateinit var editTextAmount: EditText
    private lateinit var editTextNombre: EditText
    private lateinit var editTextDescripcion: EditText
    private lateinit var editTextFecha: EditText
    private lateinit var editTextMetodoPago: EditText
    private lateinit var calendarIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla6)

        // Ajustar insets para la vista principal
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // Obtener referencias a los elementos del layout
        editTextFecha = findViewById(R.id.editTextFecha)
        calendarIcon = findViewById(R.id.calendarIcon)

        // Definir el listener para mostrar el DatePickerDialog
        val dateClick = View.OnClickListener {
            // Obtener la fecha actual
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            // Mostrar DatePickerDialog
            val datePickerDialog = DatePickerDialog(
                this,
                { _, year, monthOfYear, dayOfMonth ->
                    val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
                    editTextFecha.setText(selectedDate)
                },
                year, month, day
            )
            datePickerDialog.show()
        }

        // Asignar el listener tanto al EditText como al ImageView
        editTextFecha.setOnClickListener(dateClick)
        calendarIcon.setOnClickListener(dateClick)

        // Obtener referencias a los elementos del layout
        editTextFecha = findViewById(R.id.editTextFecha)
        calendarIcon = findViewById(R.id.calendarIcon)

        // Definir el listener para mostrar el DatePickerDialog
        val dateClickListener = View.OnClickListener {
            // Obtener la fecha actual
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            // Mostrar DatePickerDialog
            val datePickerDialog = DatePickerDialog(
                this,
                { _, year, monthOfYear, dayOfMonth ->
                    val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
                    editTextFecha.setText(selectedDate)
                },
                year, month, day
            )
            datePickerDialog.show()
        }

        // Asignar el listener tanto al EditText como al ImageView
        editTextFecha.setOnClickListener(dateClickListener)
        calendarIcon.setOnClickListener(dateClickListener)


        // Inicializar vistas
        editTextAmount = findViewById(R.id.editTextAmount)
        editTextNombre = findViewById(R.id.editTextNombre)
        editTextDescripcion = findViewById(R.id.editTextDescripcion)
        editTextFecha = findViewById(R.id.editTextFecha)
        editTextMetodoPago = findViewById(R.id.editTextMetodoPago)
        calendarIcon = findViewById(R.id.calendarIcon)

        // Configurar el botón de guardar
        val buttonGuardar: AppCompatButton = findViewById(R.id.botonguardar)
        buttonGuardar.setOnClickListener {
            saveCard()
        }
    }

    private fun saveCard() {
        val amount = editTextAmount.text.toString()
        val name = editTextNombre.text.toString()
        val description = editTextDescripcion.text.toString()
        val dueDate = editTextFecha.text.toString()
        val paymentMethod = editTextMetodoPago.text.toString()

        val card = Card(amount, name, description, dueDate, paymentMethod)

        // Añadir la tarjeta al CardManager
        CardManager.addCard(card)

        // Crear un Intent para navegar de vuelta a pantalla5
        val intent = Intent(this, pantalla5::class.java)
        startActivity(intent)
    }
}
