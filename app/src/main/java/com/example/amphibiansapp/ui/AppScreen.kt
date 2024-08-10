package com.example.amphibiansapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibiansapp.ui.screen.AppViewModel
import com.example.amphibiansapp.ui.screen.HomeScreen

@Composable
fun AppScreen (
    modifier: Modifier = Modifier
) {
    val viewModel : AppViewModel = viewModel(factory = AppViewModel.Factory)
    HomeScreen(
        onRetry =  viewModel::getCardDetails ,
        appUiState = viewModel.appUiState ,
        modifier =  Modifier.fillMaxSize()


     )
}

@Preview
@Composable
fun AppScreenPreview() {
    AppScreen()
}