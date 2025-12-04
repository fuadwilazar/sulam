package com.example.mpib

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// 1. Data Model Class
data class NewsItem(
    val title: String,
    val date: String,
    val tag: String,
    val imageResId: Int // Resource ID for the drawable image
)

class NewsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.news_recycler_view)

        // 2. Create Dummy Data (Your 3 News Items)
        val newsList = listOf(
            NewsItem(
                "MPIB Launches New Export Program to Boost MD2 Pineapple Sales",
                "December 3, 2025",
                "Program",
                R.drawable.pineapple_background // Use your existing image
            ),
            NewsItem(
                "Pineapple Research Institute Identifies Key to Disease Resistance in Johor Farms",
                "November 28, 2025",
                "Research",
                R.drawable.pineapple_background
            ),
            NewsItem(
                "Perak Farmers Achieve Record Harvest Amidst Favorable Weather Conditions",
                "November 15, 2025",
                "Market Update",
                R.drawable.pineapple_background
            )
        )

        // 3. Set up RecyclerView Adapter
        recyclerView.adapter = NewsAdapter(newsList)
        return view
    }
}

// 4. RecyclerView Adapter Implementation
class NewsAdapter(private val newsList: List<NewsItem>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.news_title)
        val date: TextView = itemView.findViewById(R.id.news_date)
        val tag: TextView = itemView.findViewById(R.id.news_tag)
        // Note: Image view would also be linked here
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_news_item, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = newsList[position]
        holder.title.text = currentItem.title
        holder.date.text = currentItem.date
        holder.tag.text = currentItem.tag
        // Set the image resource here (e.g., holder.imageView.setImageResource(currentItem.imageResId))
    }

    override fun getItemCount() = newsList.size
}