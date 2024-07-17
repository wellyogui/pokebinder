package br.com.well.service.di

import br.com.well.service.BuildConfig
import br.com.well.service.ParamsInterceptor
import br.com.well.service.card.PokemonCardService
import br.com.well.service.set.PokemonSetService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideParamsInterceptor() = ParamsInterceptor()

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    @Provides
    fun provideOkHttpClient(
        paramsInterceptor: ParamsInterceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(paramsInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun provideSetService(
        client: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): PokemonSetService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addConverterFactory(gsonConverterFactory)
            .build()
            .create(PokemonSetService::class.java)
    }

    @Provides
    fun provideCardService(
        client: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): PokemonCardService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addConverterFactory(gsonConverterFactory)
            .build()
            .create(PokemonCardService::class.java)
    }
}