package br.com.emersonfiwre.jetpacknavigation.di

import dagger.Module
import dagger.Provides

@Module
class StringModule {

    @Provides
    fun provideString(): String {
        return "Hello World"
    }
}