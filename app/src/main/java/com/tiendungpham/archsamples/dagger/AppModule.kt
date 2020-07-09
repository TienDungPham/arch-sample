package com.tiendungpham.archsamples.dagger

import com.tiendungpham.archsamples.ui.game.GameViewModelFactory
import com.tiendungpham.core.dagger.scope.FeatureScope
import com.tiendungpham.core.data.source.WordRepository
import dagger.Module
import dagger.Provides

@Module
abstract class AppModule {
    companion object {
        @FeatureScope
        @Provides
        fun provideGameViewModelFactory(wordRepository: WordRepository): GameViewModelFactory {
            return GameViewModelFactory(wordRepository)
        }
    }
}