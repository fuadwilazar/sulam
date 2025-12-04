package com.example.mpib

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // R.layout.fragment_home must contain the full UI from your original activity_main.xml
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}