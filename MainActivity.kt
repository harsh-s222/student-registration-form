package com.example.studentregistration

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<EditText>(R.id.etName)
        val roll = findViewById<EditText>(R.id.etRoll)
        val department = findViewById<EditText>(R.id.etDepartment)
        val year = findViewById<EditText>(R.id.etYear)
        val email = findViewById<EditText>(R.id.etEmail)
        val phone = findViewById<EditText>(R.id.etPhone)
        val submit = findViewById<Button>(R.id.btnSubmit)

        submit.setOnClickListener {

            val nameText = name.text.toString().trim()
            val rollText = roll.text.toString().trim()
            val deptText = department.text.toString().trim()
            val yearText = year.text.toString().trim()
            val emailText = email.text.toString().trim()
            val phoneText = phone.text.toString().trim()

            if (nameText.isEmpty()) {
                name.error = "Name required"
                return@setOnClickListener
            }

            if (rollText.isEmpty()) {
                roll.error = "Roll number required"
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
                email.error = "Enter valid email"
                return@setOnClickListener
            }

            if (phoneText.length != 10) {
                phone.error = "Enter valid 10 digit phone number"
                return@setOnClickListener
            }

            Toast.makeText(
                this,
                "Registration Successful!",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
