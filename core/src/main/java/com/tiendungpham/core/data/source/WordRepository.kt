package com.tiendungpham.core.data.source

import com.tiendungpham.core.data.Word
import kotlinx.coroutines.flow.Flow

class WordRepository(private val localWordDataSource: WordDataSource) {
    suspend fun createWord(word: Word) {
        localWordDataSource.createWord(word)
    }

    suspend fun deleteWord(word: Word) {
        localWordDataSource.deleteWord(word)
    }

    fun getAllWord(): Flow<List<Word>> = localWordDataSource.getAllWord()
}