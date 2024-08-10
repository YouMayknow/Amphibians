package com.example.amphibiansapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibiansapp.R
import com.example.amphibiansapp.model.Card

@Composable
fun HomeScreen (
    onRetry: () -> Unit,
    appUiState: AppUiState,
    modifier: Modifier = Modifier,
) {
   when (appUiState){
       is AppUiState.Success -> SuccessScreen(cards = appUiState.cards , modifier = modifier)
       is AppUiState.Loading -> LoadingScreen()
       else -> ErrorScreen(
           onRetry = onRetry ,
           modifier = modifier.fillMaxSize()
       )
   }
}

@Composable
fun LoadingScreen (modifier: Modifier = Modifier) {
    Image(painter = painterResource(id = R.drawable.loading_img) ,
        contentDescription =  null ,
        modifier =  modifier.size(200.dp)
    )
}

@Composable
fun ErrorScreen (
    modifier: Modifier = Modifier ,
    onRetry : () -> Unit
) {
    Column(
        modifier = modifier ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
      Image(
          painter = painterResource(id = R.drawable.ic_connection_error),
          contentDescription = null
      )
      Button(onClick = onRetry ) {
          Text(text = "Retry")
      }
    }
}
@Composable
fun SuccessScreen(
    modifier: Modifier = Modifier  ,
    cards : List<Card>
) {
    LazyColumn {
        items(
            items = cards ,
            key = {card -> card.name}
        ){ card ->
            DetailedCard(card = card)
        }
    }
}

@Composable
fun DetailedCard (
    card: Card,
    modifier: Modifier = Modifier
) {
    Card( modifier = modifier.fillMaxWidth()
    ) {
        Column (
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = card.name
            )
            CardImage(card = card )
            Text(text = card.description)
            Text(text = card.type)

        }
    }
}

@Composable
fun CardImage(
    card : Card,
    modifier: Modifier = Modifier
) {

    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(card.imgSrc)
            .crossfade(true)
            .build()
        ,
        contentDescription = null  ,
        placeholder = painterResource(id = R.drawable.broken_image) ,
        error = painterResource(id = R.drawable.loading_img) ,
        contentScale = ContentScale.Crop ,
        modifier = modifier.aspectRatio(1.5f),


    )
}

@Composable
@Preview
fun HomeScreenPreview () {
   // DetailedCard()
}