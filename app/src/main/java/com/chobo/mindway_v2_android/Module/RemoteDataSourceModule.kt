package com.chobo.mindway_v2_android.Module

import com.chobo.data.remote.datasource.auth.RemoteAuthDataSource
import com.chobo.data.remote.datasource.auth.RemoteAuthDataSourceImpl
import com.chobo.data.remote.datasource.book.RemoteBookDataSource
import com.chobo.data.remote.datasource.book.RemoteBookDataSourceImpl
import com.chobo.data.remote.datasource.event.RemoteEventDataSource
import com.chobo.data.remote.datasource.event.RemoteEventDataSourceImpl
import com.chobo.data.remote.datasource.order.RemoteOrderDataSource
import com.chobo.data.remote.datasource.order.RemoteOrderDataSourceImpl
import com.chobo.data.remote.datasource.rank.RemoteRankDataSource
import com.chobo.data.remote.datasource.rank.RemoteRankDataSourceImpl
import com.chobo.data.remote.datasource.recommend.RemoteRecommendDataSource
import com.chobo.data.remote.datasource.recommend.RemoteRecommendDataSourceImpl
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
        remoteBookDataSourceImpl: RemoteBookDataSourceImpl
    ): RemoteBookDataSource

    @Binds
    abstract fun provideRemoteOrderDataSource(
        remoteOrderDataSourceImpl: RemoteOrderDataSourceImpl
    ): RemoteOrderDataSource

    @Binds
    abstract fun provideRemoteRecommendDataSource(
        remoteRecommendDataSourceImpl: RemoteRecommendDataSourceImpl
    ): RemoteRecommendDataSource

    @Binds
    abstract fun provideRemoteEventDataSource(
        remoteEventDataSourceImpl: RemoteEventDataSourceImpl
    ): RemoteEventDataSource

    @Binds
    abstract fun provideRemoteRankDataSource(
        remoteRankDataSourceImpl: RemoteRankDataSourceImpl
    ): RemoteRankDataSource
}