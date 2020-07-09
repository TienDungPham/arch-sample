package com.tiendungpham.core.data.source

import com.tiendungpham.core.data.Word
import com.tiendungpham.core.data.source.local.LocalWordDataSource
import kotlinx.coroutines.flow.Flow

class WordRepository(private val localWordDataSource: LocalWordDataSource) {
    suspend fun createWord(word: Word) {
        localWordDataSource.createWord(word)
    }

    suspend fun deleteWord(word: Word) {
        localWordDataSource.deleteWord(word)
    }

    fun getAllWord(): Flow<List<Word>> = localWordDataSource.getAllWord()
}