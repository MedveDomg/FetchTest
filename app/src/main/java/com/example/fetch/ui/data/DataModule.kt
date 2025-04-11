package com.example.fetch.data

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

internal val dataModule = module {

    single {
        val builder = OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
        builder.build()
    }

    factory {
        Moshi.Builder().build()
    }

    single {
        val okHttpClient: OkHttpClient = get()
        val moshi: Moshi = get()
        val converterFactory = MoshiConverterFactory.create(moshi)

        Retrofit.Builder()
            .baseUrl("https://fetch-hiring.s3.amazonaws.com/")
            .addConverterFactory(converterFactory)
            .client(okHttpClient)
            .build()
    }

    single<InfoService> {
        val retrofit: Retrofit = get()
        retrofit.create(InfoService::class.java)
    }

    single<InfoRepository> {
        InfoRepository(service = get())
    }
}