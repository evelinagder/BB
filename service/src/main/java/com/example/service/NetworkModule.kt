package com.example.service

import com.example.service.character.CharacterListRepository
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
object NetworkModule {

    private const val TIMEOUT: Long = 20
    private const val BASE_URL = "https://breakingbadapi.com/api/"

    /**
     * Provides the retrofit instance.
     * @return new retrofit instance if the api endpoint has changed
     */
    @Provides
    @JvmStatic
    @Singleton
    @Suppress("LongParameterList")
    fun provideRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(provideOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    /**
     * Provides the http client instance.
     *
     * @return new http client
     */
    @Suppress("SpreadOperator")
    private fun provideOkHttpClient(): OkHttpClient {

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val builder = OkHttpClient.Builder()

        return builder
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    fun provideBreakingBadApi(retrofit: Retrofit): BreakingBadApi =
        retrofit.create(BreakingBadApi::class.java)

    @Provides
    fun provideCharacterListRepository(api: BreakingBadApi) = CharacterListRepository(api)
}
