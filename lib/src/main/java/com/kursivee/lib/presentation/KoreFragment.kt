package com.kursivee.lib.presentation

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kursivee.lib.dagger.KoreComponent
import javax.inject.Inject
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

val KoreFragment.koreApp: KoreApplication
    get() = requireActivity().application as KoreApplication


abstract class KoreFragment: Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    inline fun <reified VM: ViewModel> viewModel() = object: ReadOnlyProperty<KoreFragment, VM> {
        override fun getValue(thisRef: KoreFragment, property: KProperty<*>): VM =
            ViewModelProvider(thisRef, viewModelFactory)[VM::class.java]
    }
}