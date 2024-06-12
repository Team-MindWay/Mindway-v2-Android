package com.chobo.mindway_v2_android.module

import com.chobo.data.repository.AuthRepositoryImpl
import com.chobo.data.repository.BookRepositoryImpl
import com.chobo.data.repository.EventRepositoryImpl
import com.chobo.data.repository.GoalRepositoryImpl
import com.chobo.data.repository.MyRepositoryImpl
import com.chobo.data.repository.NoticeRepositoryImpl
import com.chobo.data.repository.OrderRepositoryImpl
import com.chobo.data.repository.RankRepositoryImpl
import com.chobo.data.repository.RecommendRepositoryImpl
import com.chobo.domain.repository.AuthRepository
import com.chobo.domain.repository.BookRepository
import com.chobo.domain.repository.EventRepository
import com.chobo.domain.repository.GoalRepository
import com.chobo.domain.repository.MyRepository
import com.chobo.domain.repository.NoticeRepository
import com.chobo.domain.repository.OrderRepository
import com.chobo.domain.repository.RankRepository
import com.chobo.domain.repository.RecommendRepository
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

    @Binds
    abstract fun provideRecommendRepository(
        recommendRepositoryImpl: RecommendRepositoryImpl
    ): RecommendRepository

    @Binds
    abstract fun provideNoticeRepository(
        noticeRepositoryImpl: NoticeRepositoryImpl
    ): NoticeRepository

    @Binds
    abstract fun provideEventRepository(
        eventRepositoryImpl: EventRepositoryImpl
    ): EventRepository

    @Binds
    abstract fun provideRankRepository(
        rankRepositoryImpl: RankRepositoryImpl
    ): RankRepository

    @Binds
    abstract fun provideMyRepository(
        myRepositoryImpl: MyRepositoryImpl
    ): MyRepository

    @Binds
    abstract fun provideGoalRepository(
        goalRepositoryImpl: GoalRepositoryImpl
    ): GoalRepository
}