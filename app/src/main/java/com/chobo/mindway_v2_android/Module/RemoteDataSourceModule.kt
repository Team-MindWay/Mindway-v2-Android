package com.chobo.mindway_v2_android.Module

import com.chobo.data.remote.datasource.auth.RemoteAuthDataSource
import com.chobo.data.remote.datasource.auth.RemoteAuthDataSourceImpl
import com.chobo.data.remote.datasource.book.RemoteBookDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {
    @Binds
    abstract fun provideRemoteAuthDataSource(
        remoteAuthDataSourceImpl: RemoteAuthDataSourceImpl
    ): RemoteAuthDataSource

    @Binds
    abstract fun provideRemoteBookDataSource(
        remoteBookDataSourceImpl: RemoteAuthDataSourceImpl
    ): RemoteBookDataSource
}