package com.example.mpib

data class Entrepreneur(
    val name: String,
    val businessName: String,
    val specialty: String,
    val location: String,
    val phone: String,
    val email: String,
    val acres: String,
    val stockStatus: String,
    val stockStatusType: StockStatusType,
    val quantity: String
)

enum class StockStatusType {
    FRESH_HARVEST,
    IN_STOCK,
    LOW_STOCK
}
