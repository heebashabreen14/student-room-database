package com.example.roomdatabaseexample.modal

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "table_student")
data class Student(

    @PrimaryKey
    @ColumnInfo(name = "column_student_word")
    val studentName: String

) : Parcelable
