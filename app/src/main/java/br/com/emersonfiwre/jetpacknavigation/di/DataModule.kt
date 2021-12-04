package br.com.emersonfiwre.jetpacknavigation.di

import br.com.emersonfiwre.jetpacknavigation.data.DefaultRepository
import br.com.emersonfiwre.jetpacknavigation.data.Repository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class DataModule {

    @Singleton// somente injetar a instancia do DefaultRepository se ele já foi criado anteriormente
    @Binds
    abstract fun provideLocalDataSource(repository: DefaultRepository): Repository
}