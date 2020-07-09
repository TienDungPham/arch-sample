package com.tiendungpham.core.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word")
class Word(
    @PrimaryKey
    val id: String,
    val title: String
)