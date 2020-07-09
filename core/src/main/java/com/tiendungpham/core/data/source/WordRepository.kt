package com.tiendungpham.core.data.source

import com.tiendungpham.core.data.Word
import com.tiendungpham.core.data.source.local.LocalWordDataSource
import com.tiendungpham.core.data.source.remote.RemoteWordDataSource
import kotlinx.coroutines.flow.Flow

class WordRepository(
    private val localWordDataSource: LocalWordDataSource,
    private val remoteWordDataSource: RemoteWordDataSource
) {
    suspend fun createWord(word: Word) {
        localWordDataSource.createWord(word)
        //remoteWordDataSource.createWord(word)
    }

    suspend fun deleteWord(word: Word) {
        localWordDataSource.deleteWord(word)
        //remoteWordDataSource.deleteWord(word)
    }

    fun getAllWord(): Flow<List<Word>> {
        //return localWordDataSource.findAllWord()
        return remoteWordDataSource.findAllWord()
    }

    suspend fun getAllWordAsList(): List<Word> {
//        return localWordDataSource.findAllWordAsList()
        return remoteWordDataSource.findAllWordAsList()
    }
}