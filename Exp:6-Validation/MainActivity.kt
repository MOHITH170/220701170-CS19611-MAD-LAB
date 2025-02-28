package com.example.exp6a

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var idEditText: EditText
    private lateinit var validateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usernameEditText = findViewById(R.id.usernameEditText)
        idEditText = findViewById(R.id.idEditText)
        validateButton = findViewById(R.id.validateButton)

        validateButton.setOnClickListener {
            val username = usernameEditText.text.toString().trim()
            val id = idEditText.text.toString().trim()

            if (username.isEmpty() || id.isEmpty()) {
                Toast.makeText(this, "Empty fields!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!isValidUsername(username)) {
                Toast.makeText(this, "Invalid username!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!isValidId(id)) {
                Toast.makeText(this, "Invalid ID!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isValidUsername(username: String): Boolean {
        val usernamePattern = "^[a-zA-Z]+$"
        return Pattern.compile(usernamePattern).matcher(username).matches()
    }

    private fun isValidId(id: String): Boolean {
        val idPattern = "^[0-9]{4}$"
        return Pattern.compile(idPattern).matcher(id).matches()
    }
}
