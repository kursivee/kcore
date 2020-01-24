package com.kursivee.kcore.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kursivee.kcore.R
import com.kursivee.kcore.ui.dagger.DaggerMainComponent
import com.kursivee.kcore.ui.dagger.MainComponent
import com.kursivee.lib.presentation.KoreFragment
import com.kursivee.lib.presentation.koreApp
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : KoreFragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModel()

    private val component: MainComponent by lazy {
        DaggerMainComponent.builder()
            .koreComponent(koreApp.component)
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        message.text = viewModel.foo
    }

}
