package domain

interface TestRepository {
    fun get() : String
    fun set(value : String)
}
