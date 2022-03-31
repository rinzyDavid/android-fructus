package com.david.fructus.di

import android.content.Context
import com.david.fructus.data.dao.FruitDao
import com.david.fructus.data.db.FruitDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * This module helps to create, inject database and dao instances
 */

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): FruitDatabase {
        return FruitDatabase.getInstance(context)
    }

    @Provides
    fun providePlantDao(appDatabase: FruitDatabase): FruitDao {
        return appDatabase.fruitDao()
    }



}