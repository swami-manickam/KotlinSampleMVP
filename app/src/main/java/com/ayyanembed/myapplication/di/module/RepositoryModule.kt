package com.ayyanembed.myapplication.di.module

import com.ayyanembed.myapplication.app.ApiConstants
import com.ayyanembed.myapplication.repo.MyApplicationApi
import com.ayyanembed.myapplication.repo.MyApplicationRepo
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class RepositoryModule {

  private val TAG = RepositoryModule::class.java.simpleName

  @Provides
  @Singleton
  @Named("Gson")
  fun providesGson(): Gson {
    return GsonBuilder()
        .setDateFormat(ApiConstants.API_DATE_FORMAT)
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .serializeNulls()
        .create()
  }

  @Provides
  @Singleton
  internal fun providesLoggingInterceptor(): HttpLoggingInterceptor {
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY
    return logging
  }

  @Provides
  @Singleton
  @Named("BaseOkHttp")
  fun providesBaseOkHttpClient(logger: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient.Builder().addInterceptor(logger)
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .build()
  }

  @Provides
  @Singleton
  internal fun providesFoodStoriesRepo(
    @Named("BaseOkHttp") httpClient: OkHttpClient,
    @Named("Gson") gson: Gson
  ): MyApplicationRepo {
    val retrofit = Retrofit.Builder().client(httpClient)

        .baseUrl(ApiConstants.BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    return MyApplicationRepo(retrofit.create(MyApplicationApi::class.java))
  }


  @Provides
  @Singleton
  @Named("MaxOkHttp")
  fun providesMaxOkHttpClient(
    @Named("BaseOkHttp") okHttpClient: OkHttpClient,
    logger: HttpLoggingInterceptor
  ): OkHttpClient {
    return okHttpClient.newBuilder()
        .addInterceptor(logger)
        .build()
  }

}