package ru.narbut.kmmfronttemp.presentation.app.auth.main

import domain.TestRepository
import ru.narbut.kmmfronttemp.presentation.navigation.component.ViewModel

class MainViewModel(testRepository: TestRepository) : ViewModel(){

    init {
        println("init Main")
    }

    override fun onResume() {
        super.onResume()
        println("onResume Main")
    }

    override fun onPause() {
        super.onPause()
        println("onPause Main")
    }

    override fun onStart() {
        super.onStart()
        println("onStart Main")
    }

    override fun onStop() {
        super.onStop()
        println("onStop Main")
    }

    override fun destroy() {
        super.destroy()
        println("destroy Main")
    }
}