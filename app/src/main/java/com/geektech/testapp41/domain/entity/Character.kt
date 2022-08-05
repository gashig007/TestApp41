package com.geektech.testapp41.domain.entity

import android.os.Parcelable
import android.webkit.WebStorage
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
data class Character(
    @ColumnInfo(name = "character's id")
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("origin")
    @Embedded(prefix = "origins")
    val origin: WebStorage.Origin,
    @SerializedName("location")
    @Embedded(prefix = "locations")
    val location:   Location,
    @SerializedName("image")
    val image: String,
    @SerializedName("episode")
    val episodes: List<String>,
    @SerializedName("url")
    val url: String,
    @SerializedName("created")
    val created: String
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

data class CharacterResponse(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<Character?>?
)

data class Info(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)

@Entity
data class CharacterEpisode(
    @ColumnInfo(name = "episode's id")
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("air_date")
    val air_date: String,
    @ColumnInfo(name = "episode's code")
    val episode: String,
    @SerializedName("characters")
    val characters: List<String>,
    @SerializedName("url")
    val url: String,
    @SerializedName("created")
    val created: String
)

@Entity
data class CharacterLocation(
    @ColumnInfo(name = "location's id ")
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    @ColumnInfo(name = "location's type")
    val type: String,
    @SerializedName("dimension")
    val dimension: String,
    @SerializedName("residents")
    val residents: List<String>,
    @SerializedName("url")
    val url: String,
    @SerializedName("created")
    val created: String
)