package com.tiendungpham.archsamples.dagger

import com.tiendungpham.archsamples.ui.game.GameFragment
import com.tiendungpham.core.dagger.CoreComponent
import com.tiendungpham.core.dagger.scope.FeatureScope
import dagger.Component

@FeatureScope
@Component(dependencies = [CoreComponent::class], modules = [AppModule::class])
interface AppComponent {

    fun injectGame(gameFragment: GameFragment)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        fun setCoreComponent(coreComponent: CoreComponent): Builder
    }
}