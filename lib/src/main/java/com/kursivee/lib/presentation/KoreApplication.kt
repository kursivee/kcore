package com.kursivee.lib.presentation

import android.app.Application
import com.kursivee.lib.dagger.DaggerKoreComponent
import com.kursivee.lib.dagger.KoreComponent

abstract class KoreApplication: Application() {

    val component: KoreComponent by lazy {
        DaggerKoreComponent.create()
    }
}