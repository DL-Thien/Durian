package com.longthien.core.data.di

import com.longthien.core.data.repositories.ConfigRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface CoreDataModule {

    @Provides
    fun provideConfigRepository(configRepositoryIpl: ConfigRepositoryImpl)
}