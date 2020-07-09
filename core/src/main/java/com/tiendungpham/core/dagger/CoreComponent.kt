package com.tiendungpham.core.dagger

import android.content.Context
import com.tiendungpham.core.data.source.WordRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class])
interface CoreComponent {

    fun provideWordRepository(): WordRepository

    @Component.Builder
    interface Builder {
        fun build(): CoreComponent

        @BindsInstance
        fun setContext(context: Context): Builder
    }
}