package com.recordstore

import com.fasterxml.jackson.annotation.JsonProperty

data class Records(
        @JsonProperty("records") var records: List<Record>? = listOf()
) {

    data class Record(
            @JsonProperty("id") var id: String? = "",
            @JsonProperty("name") var name: String? = "",
            @JsonProperty("price") var price: Double? = 0.0,
            @JsonProperty("artist") var artist: String? = "",
            @JsonProperty("isFavourite") var isFavourite: Boolean? = false,
            @JsonProperty("img") var img: String? = "",
            @JsonProperty("desc") var desc: String? = "",
            @JsonProperty("bucket") var bucket: Bucket? = Bucket(),
            @JsonProperty("releaseDate") var releaseDate: String? = "",
            @JsonProperty("label") var label: String? = "",
            @JsonProperty("records") var records: List<Record>? = listOf()
    ) {
        data class Bucket(
                @JsonProperty("addToBucket") var addToBucket: Boolean? = false,
                @JsonProperty("NumberAdded") var numberAdded: Int? = 0
        )
    }
}