package ru.narbut.kmmfronttemp.di

object KoinModules {
    val AppModules = listOf(
        RepositoryDependencies.RepositoryModule,
        ViewModelDependencies.ViewModelModule
    )
}