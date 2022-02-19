package android.example.flowerschemistry.models

data class YourOrder(
    val id: Int,
    var name: String,
    var date: String,
    var price: Int,
    var address: String,
    var status: String,
    var img: Int
)
