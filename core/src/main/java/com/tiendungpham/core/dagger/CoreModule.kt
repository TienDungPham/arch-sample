package com.tiendungpham.core.dagger

import android.content.Context
import com.tiendungpham.core.data.source.WordDataSource
import com.tiendungpham.core.data.source.local.LocalWordDataSource
import com.tiendungpham.core.data.source.local.WordDatabase
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
abstract class CoreModule {

    companion object {
        @Provides
        fun provideDatabase(context: Context): WordDatabase {
            return WordDatabase.create(context)
        }

        @Provides
        fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO

        @Provides
        fun provideWordDataSource(
            wordDatabase: WordDatabase,
            ioDispatcher: CoroutineDispatcher
        ): WordDataSource {
            return LocalWordDataSource(wordDatabase.wordDao(), ioDispatcher)
        }
    }
}