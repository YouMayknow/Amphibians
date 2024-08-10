package com.example.amphibiansapp.data

import com.example.amphibiansapp.network.AppApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit


interface AppContainer {
    val cardRepository : CardRepository
}

class DefaultAppContainer : AppContainer {
    private val baseUrl =  "https://android-kotlin-fun-mars-server.appspot.com/"
    private val retrofit : Retrofit  =  Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
      //  .addCallAdapterFactory(CoroutineCallAdapterFactory())
       .baseUrl(baseUrl)
       .build()

    private val retrofitService : AppApiService by lazy {
        retrofit.create(AppApiService::class.java)
    }
    override val cardRepository: CardRepository by lazy {
        NetworkCardRepository(retrofitService)
    }
}