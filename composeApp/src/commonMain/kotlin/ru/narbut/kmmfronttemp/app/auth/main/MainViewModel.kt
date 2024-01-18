package ru.narbut.kmmfronttemp.app.auth.main

import ru.narbut.kmmfronttemp.data.NetworkRepository
import ru.narbut.kmmfronttemp.navigation.component.ViewModel

class MainViewModel(networkRepository: NetworkRepository) : ViewModel(){

    init {
        println("init")
    }

    override fun onResume() {
        super.onResume()
        println("onResume")
    }

    override fun onPause() {
        super.onPause()
        println("onPause")
    }

    override fun onStart() {
        super.onStart()
        println("onStart")
    }

    override fun onStop() {
        super.onStop()
        println("onStop")
    }
}