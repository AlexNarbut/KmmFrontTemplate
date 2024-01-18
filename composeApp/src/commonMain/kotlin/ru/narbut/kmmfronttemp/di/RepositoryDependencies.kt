package ru.narbut.kmmfronttemp.di

import org.koin.dsl.module
import ru.narbut.kmmfronttemp.data.NetworkRepository
import ru.narbut.kmmfronttemp.data.NetworkRepositoryImpl

class RepositoryDependencies {
    companion object {
        val RepositoryModule = module {
            single <NetworkRepository> { NetworkRepositoryImpl() }
        }
    }
}