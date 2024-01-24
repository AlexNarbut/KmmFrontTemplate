package ru.narbut.kmmfronttemp.di

import data.TestRepositoryImpl
import domain.TestRepository
import org.koin.dsl.module

class RepositoryDependencies {
    companion object {
        val RepositoryModule = module {
            single <TestRepository> { TestRepositoryImpl() }
        }
    }
}