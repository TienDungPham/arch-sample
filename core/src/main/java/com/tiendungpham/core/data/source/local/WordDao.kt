package com.tiendungpham.core.data.source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.tiendungpham.core.data.Word
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {
    @Insert
    fun createWord(word: Word)

    @Delete
    fun deleteWord(word: Word)

    @Query("SELECT * FROM word")
    fun findAllWord(): Flow<List<Word>>

    @Query("SELECT * FROM word")
    fun findAllWordAsList(): List<Word>
}