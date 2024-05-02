package com.chobo.mindway_v2_android.Module

import com.chobo.data.repository.AuthRepositoryImpl
import com.chobo.data.repository.BookRepositoryImpl
import com.chobo.data.repository.OrderRepositoryImpl
import com.chobo.domain.repository.AuthRepository
import com.chobo.domain.repository.BookRepository
import com.chobo.domain.repository.OrderRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    abstract fun provideBookRepository(
        bookRepositoryImpl: BookRepositoryImpl
    ): BookRepository

    @Binds
    abstract fun provideOrderRepository(
        orderRepositoryImpl: OrderRepositoryImpl
    ): OrderRepository
}