package tech.tarakoshka.bridgemich.data.dtos

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
import kotlinx.serialization.json.JsonElement


@Serializable
data class Assets(
    @SerialName("total") var total: Int? = null,
    @SerialName("count") var count: Int? = null,
    @SerialName("items") var items: ArrayList<Items> = arrayListOf(),
    @SerialName("facets") var facets: List<JsonElement> = emptyList(),
    @SerialName("nextPage") var nextPage: String? = null
)