package data

import domain.TestRepository

class TestRepositoryImpl : TestRepository {
    private var string : String = "asd"

    override fun get(): String = string

    override fun set(value: String) {
        string = value
    }
}