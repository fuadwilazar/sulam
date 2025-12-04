package com.example.mpib

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EntrepreneurAdapter(
    private val allEntrepreneurs: List<Entrepreneur>
) : RecyclerView.Adapter<EntrepreneurAdapter.EntrepreneurViewHolder>(), Filterable {

    private var filteredEntrepreneurs: List<Entrepreneur> = allEntrepreneurs

    inner class EntrepreneurViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_name)
        val tvBusinessName: TextView = itemView.findViewById(R.id.tv_business_name)
        val tvSpecialty: TextView = itemView.findViewById(R.id.tv_specialty)
        val tvAcres: TextView = itemView.findViewById(R.id.tv_acres)
        val tvStockStatus: TextView = itemView.findViewById(R.id.tv_stock_status)
        val tvQuantity: TextView = itemView.findViewById(R.id.tv_quantity)
        val tvLocation: TextView = itemView.findViewById(R.id.tv_location)
        val tvPhone: TextView = itemView.findViewById(R.id.tv_phone)
        val tvEmail: TextView = itemView.findViewById(R.id.tv_email)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntrepreneurViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_entrepreneur, parent, false)
        return EntrepreneurViewHolder(view)
    }

    override fun onBindViewHolder(holder: EntrepreneurViewHolder, position: Int) {
        val entrepreneur = filteredEntrepreneurs[position]
        
        holder.tvName.text = entrepreneur.name
        holder.tvBusinessName.text = entrepreneur.businessName
        holder.tvSpecialty.text = entrepreneur.specialty
        holder.tvAcres.text = entrepreneur.acres
        holder.tvStockStatus.text = entrepreneur.stockStatus
        holder.tvQuantity.text = entrepreneur.quantity
        holder.tvLocation.text = entrepreneur.location
        holder.tvPhone.text = entrepreneur.phone
        holder.tvEmail.text = entrepreneur.email

        // Style stock status based on type
        when (entrepreneur.stockStatusType) {
            StockStatusType.FRESH_HARVEST -> {
                holder.tvStockStatus.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_fresh_harvest, 0, 0, 0
                )
                holder.tvStockStatus.compoundDrawablePadding = 4
            }
            StockStatusType.IN_STOCK -> {
                holder.tvStockStatus.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_check_stock, 0, 0, 0
                )
                holder.tvStockStatus.compoundDrawablePadding = 4
                holder.tvStockStatus.setBackgroundResource(R.drawable.bg_tag_blue)
                holder.tvStockStatus.setPadding(6, 2, 6, 2)
            }
            StockStatusType.LOW_STOCK -> {
                holder.tvStockStatus.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_warning_stock, 0, 0, 0
                )
                holder.tvStockStatus.compoundDrawablePadding = 4
            }
        }
    }

    override fun getItemCount(): Int = filteredEntrepreneurs.size

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val query = constraint?.toString()?.lowercase()?.trim() ?: ""
                
                val filtered = if (query.isEmpty()) {
                    allEntrepreneurs
                } else {
                    allEntrepreneurs.filter { entrepreneur ->
                        entrepreneur.name.lowercase().contains(query) ||
                        entrepreneur.businessName.lowercase().contains(query) ||
                        entrepreneur.location.lowercase().contains(query) ||
                        entrepreneur.specialty.lowercase().contains(query)
                    }
                }

                return FilterResults().apply {
                    values = filtered
                }
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredEntrepreneurs = results?.values as? List<Entrepreneur> ?: emptyList()
                notifyDataSetChanged()
            }
        }
    }
}
