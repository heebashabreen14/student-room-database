package com.example.roomdatabaseexample.repository.database

import androidx.room.*
import com.example.roomdatabaseexample.modal.Student
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentDao {

    @Query("SELECT * FROM table_student ORDER BY column_student_word ASC")
    fun getAlphabetizedStudents(): Flow<List<Student>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(student: Student)

    @Query("DELETE FROM table_student")
    suspend fun deleteAll()

    //@Query("DELETE FROM table_word")
    //suspend fun deleteOne(word: Word)

    @Delete
    suspend fun deleteOneStudent(student: Student)

}


