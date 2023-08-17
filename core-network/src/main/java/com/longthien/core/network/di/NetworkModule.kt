package com.longthien.core.network.di

import com.longthien.core.network.BuildConfig
import com.longthien.core.network.apis.CurrencyApi
import com.longthien.core.network.apis.StoreConfigApi
import com.longthien.core.network.datasources.ConfigRemoteDataSources
import com.longthien.core.network.interceptor.AccessTokenInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NetworkModuleProvide {

    @Binds
    fun bindConfigRemoteDataSource(configRemoteDataSourceImpl: ConfigRemoteDataSources): ConfigRemoteDataSources
}

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    fun provideCurrencyApi(retrofit: Retrofit): CurrencyApi {
        return retrofit.create(CurrencyApi::class.java)
    }

    @Singleton
    fun provideStoreConfigApi(retrofit: Retrofit): StoreConfigApi {
        return retrofit.create(StoreConfigApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        moshiConverterFactory: MoshiConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder().addConverterFactory(moshiConverterFactory)
            .baseUrl(BuildConfig.baseUrl)
            .client(okHttpClient).build()
    }

    @Singleton
    @Provides
    fun provideMoshiConverter(): MoshiConverterFactory {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        return MoshiConverterFactory.create(moshi)
    }

    @Singleton
    @Provides
    fun provideOkhttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.addNetworkInterceptor(AccessTokenInterceptor(accessToken = BuildConfig.accessToken))
        if (BuildConfig.DEBUG) {
            builder.addNetworkInterceptor(httpLoggingInterceptor)
        }
        return builder.build()
    }

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

}