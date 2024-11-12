package com.example.daggerhilttuto.di

import com.example.daggerhilttuto.data.repo.MyRepoImpl
import com.example.daggerhilttuto.domain.repo.MyRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMyRepo(
        myRepoImpl: MyRepoImpl //implementation is chosen when this abstraction get injected[using inject constructor in MyRepoImpl]
    ): MyRepo
}