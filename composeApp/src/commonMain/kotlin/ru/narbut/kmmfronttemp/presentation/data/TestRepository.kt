package ru.narbut.kmmfronttemp.presentation.data

interface TestRepository {
    fun get() : String
    fun set(value : String)
}

class TestRepositoryImpl : TestRepository{
    private var string : String = "asd"

    override fun get(): String = string

    override fun set(value: String) {
        string = value
    }
}

