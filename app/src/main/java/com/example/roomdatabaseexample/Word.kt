package com.example.roomdatabaseexample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_word")
data class Word(
    @PrimaryKey
    @ColumnInfo(name = "column_word")
    val word: String
    )
