package com.example.projectharish10

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 1. Link to the layout
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // 2. Find the Logout button
        val logoutBtn = view.findViewById<Button>(R.id.btnLogout)

        // 3. Set the click listener to go back to Login
        logoutBtn.setOnClickListener {
            // This name must match the ID in your nav_graph.xml
            findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
        }

        return view
    }
}