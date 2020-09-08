package com.example.service

import com.example.service.category.CategoryListRepository
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
    private const val BASE_URL = "https://api.chucknorris.io/"

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
    fun provideChuckApi(retrofit: Retrofit): ChuckNorrisApi =
        retrofit.create(ChuckNorrisApi::class.java)

    @Provides
    fun provideCategoryListRepository(api: ChuckNorrisApi) = CategoryListRepository(api)
}
