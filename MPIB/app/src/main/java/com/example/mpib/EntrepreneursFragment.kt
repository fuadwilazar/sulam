package com.example.mpib

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EntrepreneursFragment : Fragment() {
    
    private lateinit var rvEntrepreneurs: RecyclerView
    private lateinit var etSearch: EditText
    private lateinit var adapter: EntrepreneurAdapter
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_entrepreneurs, container, false)
        
        // Initialize views
        rvEntrepreneurs = view.findViewById(R.id.rv_entrepreneurs)
        etSearch = view.findViewById(R.id.et_search)
        
        // Setup RecyclerView
        setupRecyclerView()
        
        // Setup search functionality
        setupSearch()
        
        return view
    }
    
    private fun setupRecyclerView() {
        // Hardcoded entrepreneur data
        val entrepreneurs = listOf(
            Entrepreneur(
                name = "Ahmad Bin Abdullah",
                businessName = "Ahmad Pineapple Farm",
                specialty = "MD2 Pineapples",
                location = "Johor Bahru, Johor",
                phone = "+60 12-345 6789",
                email = "ahmad@pineapplefarm.my",
                acres = "10 acres",
                stockStatus = "Fresh Harvest",
                stockStatusType = StockStatusType.FRESH_HARVEST,
                quantity = "500kg available"
            ),
            Entrepreneur(
                name = "Siti Nurhaliza",
                businessName = "Siti Fresh Pineapples",
                specialty = "Organic Pineapples",
                location = "Pontian, Johor",
                phone = "+60 13-456 7890",
                email = "siti@freshpineapple.my",
                acres = "15 acres",
                stockStatus = "In Stock",
                stockStatusType = StockStatusType.IN_STOCK,
                quantity = "150kg available"
            ),
            Entrepreneur(
                name = "Raj Kumar",
                businessName = "Golden Pineapple Enterprise",
                specialty = "Josapine",
                location = "Ipoh, Perak",
                phone = "+60 14-567 8901",
                email = "raj@goldenpineapple.my",
                acres = "20 acres",
                stockStatus = "Low Stock",
                stockStatusType = StockStatusType.LOW_STOCK,
                quantity = "45kg available"
            )
        )
        
        // Setup adapter and RecyclerView
        adapter = EntrepreneurAdapter(entrepreneurs)
        rvEntrepreneurs.layoutManager = LinearLayoutManager(requireContext())
        rvEntrepreneurs.adapter = adapter
    }
    
    private fun setupSearch() {
        etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Filter the adapter when text changes
                adapter.filter.filter(s)
            }
            
            override fun afterTextChanged(s: Editable?) {}
        })
    }
}