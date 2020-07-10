package com.tiendungpham.newword.dagger

import com.tiendungpham.core.dagger.CoreComponent
import com.tiendungpham.core.dagger.scope.FeatureScope
import com.tiendungpham.newword.ui.NewWordFragment
import dagger.Component

@FeatureScope
@Component(dependencies = [CoreComponent::class], modules = [NewWordModule::class])
interface NewWordComponent {

    fun injectNewWord(newWordFragment: NewWordFragment)

    @Component.Builder
    interface Builder {
        fun build(): NewWordComponent
        fun setCoreComponent(coreComponent: CoreComponent): Builder
    }
}