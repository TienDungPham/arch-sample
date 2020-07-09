package com.tiendungpham.archsamples

import android.app.Application
import android.content.Context
import com.tiendungpham.core.dagger.CoreComponent
import com.tiendungpham.core.dagger.DaggerCoreComponent

class GuessWordApplication : Application() {

    val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.builder().bindContext(this).build()
    }

    companion object {
        fun coreComponent(context: Context): CoreComponent =
            (context.applicationContext as GuessWordApplication).coreComponent
    }
}