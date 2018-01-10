package com.iortynskyi.hmsd.di.modules

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.iortynskyi.hmsd.di.scopes.NetworkScope
import com.iortynskyi.hmsd.network.RestApi
import com.iortynskyi.hmsd.network.rx.RxErrorCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class NetModule {

    @NetworkScope
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
    }

    @NetworkScope
    @Provides
    fun provideRxCallFactory(): CallAdapter.Factory {
        return RxErrorCallAdapterFactory.create()
    }

    @NetworkScope
    @Provides
    fun provideGsonFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @NetworkScope
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build()
    }

    @NetworkScope
    @Provides
    fun provideRetrofit(factory: GsonConverterFactory, callFactory: CallAdapter.Factory, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(factory)
                .addCallAdapterFactory(callFactory)
                .build()
    }

    @NetworkScope
    @Provides
    fun provideRestApi(retrofit: Retrofit): RestApi {
        return RestApi(retrofit)
    }

    companion object {

        private const val BASE_URL: String = ""
    }
}
