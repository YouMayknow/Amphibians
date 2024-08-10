package com.example.amphibiansapp.network

import com.example.amphibiansapp.model.Card
import retrofit2.http.GET

interface AppApiService {
    @GET("amphibians")
    suspend fun getCardDetails () : List<Card>
}
