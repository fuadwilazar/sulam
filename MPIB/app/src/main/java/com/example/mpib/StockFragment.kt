package com.example.mpib

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText

class StockFragment : Fragment() {
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_stock, container, false)
        
        // Setup FAB click listener
        val fabAddStock = view.findViewById<FloatingActionButton>(R.id.fab_add_stock)
        fabAddStock.setOnClickListener {
            showAddStockDialog()
        }
        
        return view
    }
    
    private fun showAddStockDialog() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_add_stock)
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        
        // Get dialog views
        val btnClose = dialog.findViewById<ImageView>(R.id.btn_close)
        val etProduct = dialog.findViewById<TextInputEditText>(R.id.et_product)
        val etQuantity = dialog.findViewById<TextInputEditText>(R.id.et_quantity)
        val etPrice = dialog.findViewById<TextInputEditText>(R.id.et_price)
        val btnUpdateStock = dialog.findViewById<Button>(R.id.btn_update_stock)
        
        // Close button listener
        btnClose.setOnClickListener {
            dialog.dismiss()
        }
        
        // Update stock button listener
        btnUpdateStock.setOnClickListener {
            val product = etProduct.text.toString().trim()
            val quantityStr = etQuantity.text.toString().trim()
            val priceStr = etPrice.text.toString().trim()
            
            // Validate inputs
            if (product.isEmpty()) {
                etProduct.error = "Please enter product name"
                etProduct.requestFocus()
                return@setOnClickListener
            }
            
            if (quantityStr.isEmpty()) {
                etQuantity.error = "Please enter quantity"
                etQuantity.requestFocus()
                return@setOnClickListener
            }
            
            if (priceStr.isEmpty()) {
                etPrice.error = "Please enter price"
                etPrice.requestFocus()
                return@setOnClickListener
            }
            
            val quantity = quantityStr.toDoubleOrNull()
            val price = priceStr.toDoubleOrNull()
            
            if (quantity == null || quantity <= 0) {
                etQuantity.error = "Please enter valid quantity"
                etQuantity.requestFocus()
                return@setOnClickListener
            }
            
            if (price == null || price <= 0) {
                etPrice.error = "Please enter valid price"
                etPrice.requestFocus()
                return@setOnClickListener
            }
            
            // Process the stock update
            updateStock(product, quantity, price)
            dialog.dismiss()
        }
        
        dialog.show()
    }
    
    private fun updateStock(product: String, quantity: Double, price: Double) {
        // TODO: Implement actual stock update logic here
        // This could involve:
        // - Saving to database
        // - Updating UI
        // - Sending to server
        // - Notifying buyers
        
        Toast.makeText(
            requireContext(),
            "Stock updated: $product - ${quantity}kg at RM$price/kg",
            Toast.LENGTH_LONG
        ).show()
    }
}