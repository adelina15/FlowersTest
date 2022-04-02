package android.example.flowerschemistry.models

data class BouquetSelectionItem(
    val category: CategoryX,
    val cost: Int,
    val date: String,
    val dateExp: String,
    val description: String,
    val filial: FilialX,
    val florist: FloristX,
    val flowers: List<Flower>,
    val id: Int,
    val image: String,
    val name: String,
    val selection: String,
    val status: String
)