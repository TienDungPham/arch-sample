package com.tiendungpham.core.data.source

import com.tiendungpham.core.data.Word
import kotlinx.coroutines.flow.Flow

interface WordDataSource {
    suspend fun createWord(word: Word)
    suspend fun deleteWord(word: Word)
    fun getAllWord(): Flow<List<Word>>
}