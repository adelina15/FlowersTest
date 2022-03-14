package android.example.flowerschemistry.models

data class BouquetCatalogItem(
    val category: Category,
    val cost: Int,
    val date: String,
    val dateExp: String,
    val description: String,
    val flowers: List<Flower>,
    val id: Int,
    val image: String,
    val name: String,
    val order: Any
)