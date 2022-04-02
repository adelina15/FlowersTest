package android.example.flowerschemistry.models

data class BouquetCatalogItemItem(
    val category: Category,
    val cost: Int,
    val date: String,
    val dateExp: String,
    val description: String,
    val filial: Filial,
    val florist: Florist,
    val flowers: List<Any>,
    val id: Int,
    val image: String,
    val name: String,
    val selection: String,
    val status: String
)