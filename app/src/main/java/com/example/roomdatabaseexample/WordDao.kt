package com.example.roomdatabaseexample

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {

    @Query("SELECT * FROM table_word ORDER BY column_word ASC")
    fun getAlphabetizedWords(): Flow<List<Word>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM table_word")
    suspend fun deleteAll()

    //@Query("DELETE FROM table_word")
    //suspend fun deleteOne(word: Word)

    @Delete
    suspend fun deleteOneStudent(word: Word)

}

