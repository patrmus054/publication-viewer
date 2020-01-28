package com.example.inzynieria.main.data.local.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.inzynieria.main.utilities.RoomConverter
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


@Entity(tableName = "Magazines")
@TypeConverters(RoomConverter::class)
data class MagazinesEntity constructor(
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    var id: Int = 0,

    @ColumnInfo(name = "title")
    @SerializedName("title")
    var title: String = "",

    @ColumnInfo(name = "points")
    @SerializedName("points")
    var points: Int = 0,

    @ColumnInfo(name = "parent_id")
    @SerializedName("parent_id")
    var parentId: Int = 0,

    @TypeConverters(RoomConverter::class)
    @ColumnInfo(name ="categories")
    @SerializedName("categories")
    var categories: List<String>,

    @ColumnInfo(name = "issn")
    @SerializedName("issn")
    var issn: String,

    @ColumnInfo(name = "year")
    @SerializedName("year")
    var year: Int
){
    override fun toString(): String = title


}