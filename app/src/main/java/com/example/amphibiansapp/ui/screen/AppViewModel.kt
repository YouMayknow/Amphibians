package com.example.amphibiansapp.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.amphibiansapp.AppApplication
import com.example.amphibiansapp.data.CardRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


class  AppViewModel (
   val  cardRepository: CardRepository
) : ViewModel() {


    init {
        getCardDetails()
    }

     var appUiState : AppUiState by mutableStateOf(AppUiState.Loading)
        private  set


   fun getCardDetails ()  {
       viewModelScope.launch {
       appUiState =  try {
                 AppUiState.Success(cardRepository.getCardDetails())
        } catch (e : IOException){
             AppUiState.Error
        } catch ( e : HttpException){
             AppUiState.Error
        }
       }
   }
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AppApplication)
                val cardRepository = application.appContainer.cardRepository
                AppViewModel(cardRepository = cardRepository)
            }
        }
    }

}