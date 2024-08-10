package com.example.amphibiansapp.ui.screen

import com.example.amphibiansapp.model.Card


sealed interface AppUiState{
    data class Success(val cards : List<Card>)  : AppUiState
    data object Error : AppUiState
    data object Loading : AppUiState
}
