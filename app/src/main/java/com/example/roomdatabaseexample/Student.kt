package com.example.roomdatabaseexample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_student")
data class Student(

    @PrimaryKey
    @ColumnInfo(name = "column_student_word")
    val studentName: String
)
