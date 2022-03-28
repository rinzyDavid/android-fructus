package com.david.fructus.di

import com.david.fructus.data.repository.FruitRepository
import com.david.fructus.data.repository.FruitRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun providesFruitRepository(repositoryImpl: FruitRepositoryImpl):FruitRepository
}