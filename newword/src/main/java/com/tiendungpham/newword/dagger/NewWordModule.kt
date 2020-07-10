package com.tiendungpham.newword.dagger

import com.tiendungpham.core.dagger.scope.FeatureScope
import com.tiendungpham.core.data.source.WordRepository
import com.tiendungpham.newword.ui.NewWordViewModelFactory
import dagger.Module
import dagger.Provides

@Module
abstract class NewWordModule {
    companion object {
        @FeatureScope
        @Provides
        fun provideNewWordViewModelFactory(wordRepository: WordRepository): NewWordViewModelFactory {
            return NewWordViewModelFactory(wordRepository)
        }
    }
}