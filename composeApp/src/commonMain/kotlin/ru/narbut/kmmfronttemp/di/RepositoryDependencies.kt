package ru.narbut.kmmfronttemp.di

import org.koin.dsl.module
import ru.narbut.kmmfronttemp.presentation.data.TestRepository
import ru.narbut.kmmfronttemp.presentation.data.TestRepositoryImpl

class RepositoryDependencies {
    companion object {
        val RepositoryModule = module {
            single <TestRepository> { TestRepositoryImpl() }
        }
    }
}