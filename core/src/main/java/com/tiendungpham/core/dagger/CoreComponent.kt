package com.tiendungpham.core.dagger

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component(modules = [CoreModule::class])
interface CoreComponent {

    @Component.Builder
    interface Builder {
        fun build(): CoreComponent

        @BindsInstance
        fun bindContext(context: Context): Builder
    }
}