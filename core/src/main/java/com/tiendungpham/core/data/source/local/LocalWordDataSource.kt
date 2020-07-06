package com.tiendungpham.core.data.source.local

import com.tiendungpham.core.data.Word
import com.tiendungpham.core.data.source.WordDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

class LocalWordDataSource(
    private val wordDao: WordDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : WordDataSource {
    override suspend fun createWord(word: Word) = withContext(ioDispatcher) {
        wordDao.createWord(word)
    }

    override suspend fun deleteWord(word: Word) = withContext(ioDispatcher) {
        wordDao.deleteWord(word)
    }

    override fun getAllWord(): Flow<List<Word>> = wordDao.getAllWords().flowOn(ioDispatcher)
}