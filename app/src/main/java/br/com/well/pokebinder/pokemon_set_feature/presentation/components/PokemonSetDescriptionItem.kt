package br.com.well.pokebinder.pokemon_set_feature.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.well.pokebinder.ui.theme.white
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun PokemonSetDescriptionItem(modifier: Modifier = Modifier, name: String, symbol: String, releaseDate: String) {
    Box {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current).data(symbol).crossfade(true)
                .build(),
            contentDescription = "",
            modifier = Modifier
                .padding(vertical = 10.dp)
                .size(40.dp)
        )

        Column(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.Center)) {
            Text(
                text = name,
                color = white,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 10.dp)
            )
            Text(
                text = releaseDate,
                color = white,
                fontSize = 14.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 4.dp)
            )
        }
    }
}