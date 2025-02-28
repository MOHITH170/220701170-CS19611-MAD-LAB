package com.example.assignment1

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var validateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        validateButton = findViewById(R.id.validateButton)

        validateButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Empty fields!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Invalid email!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val collegeEmailPattern = "^[0-9]{9}@rajalakshmi\\.edu\\.in$"
            if (!Pattern.compile(collegeEmailPattern).matcher(email).matches()) {
                Toast.makeText(this, "Invalid college email!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val passwordPattern = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@\$!%*?&]{8,}$"
            if (!Pattern.compile(passwordPattern).matcher(password).matches()) {
                Toast.makeText(this, "Invalid password!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "Success!", Toast.LENGTH_LONG).show()
        }
    }
}
