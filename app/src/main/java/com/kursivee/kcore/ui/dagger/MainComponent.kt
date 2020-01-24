package com.kursivee.kcore.ui.dagger

import com.kursivee.kcore.ui.main.MainFragment
import com.kursivee.lib.dagger.KoreComponent
import dagger.Component

@Component(dependencies = [
    KoreComponent::class
], modules = [
    MainViewModelModule::class
])
@MainScope
interface MainComponent {
    fun inject(mainFragment: MainFragment)
}