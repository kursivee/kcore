package com.kursivee.lib.dagger

import android.app.Application
import com.kursivee.lib.presentation.KoreApplication
import dagger.Component
import javax.inject.Singleton

val Application.koreComponent: KoreComponent
    get() = (this as KoreApplication).component

@Component
@Singleton
interface KoreComponent