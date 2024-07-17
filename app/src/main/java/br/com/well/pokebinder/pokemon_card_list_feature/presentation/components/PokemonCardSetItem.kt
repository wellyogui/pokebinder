package br.com.well.pokebinder.pokemon_card_list_feature.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.well.pokebinder.R
import br.com.well.pokebinder.ui.theme.black
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun PokemonCardItem(modifier: Modifier = Modifier,
                    id: String,
                    image: String,
                    name: String,
                    onItemClick: (id: String) -> Unit) {
    Box(modifier = modifier.background(black).padding(6.dp)) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    onItemClick(id)
                },
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current).data(image)
                    .error(R.drawable.card_placeholder)
                    .placeholder(R.drawable.card_placeholder)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.FillWidth,
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxSize()
            )
        }
    }
}

@Preview
@Composable
private fun PokemonCardItemPreview() {
    PokemonCardItem(id = "1", image = "", name = "Charizard") {

    }
}