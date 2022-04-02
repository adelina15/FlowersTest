package android.example.flowerschemistry.data.models

data class User(
    val id: Int,
    val name: String,
    val phoneNumber: String,
    val role: String? = null
)