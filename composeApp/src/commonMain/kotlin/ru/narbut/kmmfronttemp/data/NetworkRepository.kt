package ru.narbut.kmmfronttemp.data

interface NetworkRepository {
    fun get() : String
    fun set(value : String)
}

class NetworkRepositoryImpl : NetworkRepository{
    private var string : String = "asd"

    override fun get(): String = string

    override fun set(value: String) {
        string = value
    }
}

