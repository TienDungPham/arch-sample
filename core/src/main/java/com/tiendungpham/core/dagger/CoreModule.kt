package com.tiendungpham.core.dagger

import android.content.Context
import com.tiendungpham.core.data.source.WordRepository
import com.tiendungpham.core.data.source.local.LocalWordDataSource
import com.tiendungpham.core.data.source.local.WordDatabase
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
abstract class CoreModule {

    companion object {
        @Provides
        @Singleton
        fun provideDatabase(context: Context): WordDatabase {
            return WordDatabase.create(context)
        }

        @Provides
        @Singleton
        fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO

        @Provides
        @Singleton
        fun provideLocalWordDataSource(
            wordDatabase: WordDatabase,
            ioDispatcher: CoroutineDispatcher
        ): LocalWordDataSource {
            return LocalWordDataSource(wordDatabase.wordDao(), ioDispatcher)
        }

        @Provides
        @Singleton
        fun provideWordRepository(
            localWordDataSource: LocalWordDataSource
        ): WordRepository {
            return WordRepository(localWordDataSource)
        }
    }
}