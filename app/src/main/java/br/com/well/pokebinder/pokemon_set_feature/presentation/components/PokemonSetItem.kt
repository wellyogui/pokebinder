package br.com.well.pokebinder.pokemon_set_feature.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.well.pokebinder.ui.theme.black
import br.com.well.pokebinder.ui.theme.gray
import br.com.well.pokebinder.ui.theme.white
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun PokemonSetItem(
    modifier: Modifier = Modifier,
    id: String,
    name: String,
    logo: String,
    symbol: String,
    releaseDate: String,
    onClick: (id: String) -> Unit
) {
    Box(modifier = modifier.background(black)) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .height(250.dp)
                .padding(6.dp)
                .clickable {
                    onClick(id)
                },
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(gray)
                    .padding(12.dp)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current).data(logo).crossfade(true)
                        .build(),
                    contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(vertical = 4.dp)
                        .fillMaxWidth()
                        .height(150.dp)
                )

                PokemonSetDescriptionItem(name = name, symbol = symbol, releaseDate = releaseDate)
            }
        }
    }
}

@Preview
@Composable
private fun PokemonSetItemPreview() {
    PokemonSetItem(
        id = "1",
        name = "Sword and Shield",
        logo = "https://images.pokemontcg.io/swsh1/logo.png",
        symbol = "https://images.pokemontcg.io/sv5/symbol.png",
        releaseDate = "12/03/2024"
    ) {

    }
}