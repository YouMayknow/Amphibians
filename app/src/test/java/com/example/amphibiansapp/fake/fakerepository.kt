package com.example.amphibiansapp.fake

import com.example.amphibiansapp.data.CardRepository
import com.example.amphibiansapp.model.Card

class fakeApi : CardRepository {
    override suspend fun getCardDetails(): List<Card> {
         return  Fake.fakeDatasource
    }


}