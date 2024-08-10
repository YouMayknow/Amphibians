package com.example.amphibiansapp.data

import com.example.amphibiansapp.model.Card
import com.example.amphibiansapp.network.AppApiService

interface CardRepository : AppApiService {
    override suspend fun getCardDetails(): List<Card>
}


class NetworkCardRepository (
   private val marsApiService: AppApiService
)  : CardRepository{
    override suspend fun getCardDetails(): List<Card> =
         marsApiService.getCardDetails()
 // chang here
}


