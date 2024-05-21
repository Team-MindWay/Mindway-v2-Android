package com.chobo.mindway_v2_android.Module

import android.util.Log
import com.chobo.data.remote.api.AuthAPI
import com.chobo.data.remote.api.BookAPI
import com.chobo.data.remote.api.EventAPI
import com.chobo.data.remote.api.GoalAPI
import com.chobo.data.remote.api.MyAPI
import com.chobo.data.remote.api.NoticeAPI
import com.chobo.data.remote.api.OrderAPI
import com.chobo.data.remote.api.RecommendAPI
import com.chobo.data.util.AuthInterceptor
import com.chobo.mindway_v2_android.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor { message -> Log.v("HTTP", message) }
            .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun provideOkhttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        authInterceptor: AuthInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(authInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideAuthAPI(retrofit: Retrofit): AuthAPI {
        return retrofit.create(AuthAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideOrderAPI(retrofit: Retrofit): OrderAPI {
        return retrofit.create(OrderAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideMyAPI(retrofit: Retrofit): MyAPI {
        return retrofit.create(MyAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideGoalAPI(retrofit: Retrofit): GoalAPI {
        return retrofit.create(GoalAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideBookAPI(retrofit: Retrofit): BookAPI {
        return retrofit.create(BookAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideNoticeAPI(retrofit: Retrofit): NoticeAPI {
        return retrofit.create(NoticeAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideRecommendAPI(retrofit: Retrofit): RecommendAPI {
        return retrofit.create(RecommendAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideEventAPI(retrofit: Retrofit): EventAPI {
        return retrofit.create(EventAPI::class.java)
    }
}