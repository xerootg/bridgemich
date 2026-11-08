package tech.tarakoshka.bridgemich.data.dtos

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
import kotlinx.serialization.json.JsonElement


@Serializable
data class Albums(
    @SerialName("total") var total: Int? = null,
    @SerialName("count") var count: Int? = null,
    @SerialName("items") var items: List<JsonElement> = emptyList(),
    @SerialName("facets") var facets: List<JsonElement> = emptyList()
)