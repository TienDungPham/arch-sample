package com.tiendungpham.core.data.source.remote

import com.tiendungpham.core.data.Word
import com.tiendungpham.core.data.source.WordDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

class RemoteWordDataSource(private val ioDispatcher: CoroutineDispatcher) : WordDataSource {
    override suspend fun createWord(word: Word) = withContext(ioDispatcher) {
        // Delay 2000ms to simulator remote request
        delay(2000)
    }

    override suspend fun deleteWord(word: Word) = withContext(ioDispatcher) {
        // Delay 2000ms to simulator remote request
        delay(2000)
    }

    override fun findAllWord(): Flow<List<Word>> {
        return flow {
            // Delay 2000ms to simulator remote request
            delay(2000)
            emit(
                listOf(
                    Word("1", "Sun"),
                    Word("2", "Mercury"),
                    Word("3", "Venus"),
                    Word("4", "Earth"),
                    Word("5", "Mars"),
                    Word("6", "Jupiter"),
                    Word("7", "Saturn"),
                    Word("8", "Uranus"),
                    Word("9", "Neptune")
                )
            )
        }.flowOn(ioDispatcher)
    }

    override suspend fun findAllWordAsList(): List<Word> = withContext(ioDispatcher) {
        // Delay 2000ms to simulator remote request
        delay(2000)
        return@withContext listOf(
            Word("1", "Sun"),
            Word("2", "Mercury"),
            Word("3", "Venus"),
            Word("4", "Earth"),
            Word("5", "Mars"),
            Word("6", "Jupiter"),
            Word("7", "Saturn"),
            Word("8", "Uranus"),
            Word("9", "Neptune")
        )
    }
}