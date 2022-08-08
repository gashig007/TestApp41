package com.geektech.testapp41.domain.entity

import com.google.gson.annotations.SerializedName

data class CharacterPerson(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

data class Location (
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)

data class Origin (
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)