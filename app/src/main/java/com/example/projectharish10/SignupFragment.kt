package com.example.projectharish10

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth

class SignupFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_signup, container, false)

        // 1. Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        val signupBtn = view.findViewById<Button>(R.id.btnSignup)
        val emailEdit = view.findViewById<EditText>(R.id.etSignupEmail)
        val passwordEdit = view.findViewById<EditText>(R.id.etSignupPassword)

        signupBtn.setOnClickListener {
            val email = emailEdit.text.toString().trim()
            val password = passwordEdit.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                // 2. Create user in Firebase
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(context, "Registration Successful!", Toast.LENGTH_SHORT).show()
                            findNavController().navigate(R.id.action_signupFragment_to_homeFragment)
                        } else {
                            Toast.makeText(context, "Failed: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                        }
                    }
            } else {
                Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
}