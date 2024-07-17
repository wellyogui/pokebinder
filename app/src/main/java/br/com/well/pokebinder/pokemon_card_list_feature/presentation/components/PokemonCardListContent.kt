package br.com.well.pokebinder.pokemon_card_list_feature.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import br.com.well.pokebinder.ui.theme.black
import br.com.well.service.card.model.PokemonCard

@Composable
fun PokemonCardListContent(modifier: Modifier = Modifier,
                           pagingPokemonCard: LazyPagingItems<PokemonCard>,
                           paddingValues: PaddingValues,
                           onItemClick: (Int) -> Unit) {
    Box(modifier = modifier.background(black)) {
        LazyVerticalGrid(columns = GridCells.Fixed(3),
            contentPadding = paddingValues,
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()) {
            items(pagingPokemonCard.itemCount) { index ->
                val pokemonCard = pagingPokemonCard[index]
                pokemonCard?.let {

                }
            }
        }
    }
}