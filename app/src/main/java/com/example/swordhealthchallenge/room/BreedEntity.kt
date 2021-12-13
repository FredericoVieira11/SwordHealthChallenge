package com.example.swordhealthchallenge.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "breed")
data class BreedEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Int?,

    @ColumnInfo(name = "name")
    var name: String?,

    @ColumnInfo(name = "group")
    var group: String?,

    @ColumnInfo(name = "origin")
    var origin: String?,

    @ColumnInfo(name = "temperament")
    var temperament: String?,

    @ColumnInfo(name = "image")
    var image: String?
)