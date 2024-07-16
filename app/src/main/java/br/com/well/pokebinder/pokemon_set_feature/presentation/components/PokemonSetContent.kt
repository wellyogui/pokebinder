package br.com.well.pokebinder.pokemon_set_feature.presentation.components

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
import br.com.well.service.set.model.PokemonSet

@Composable
fun PokemonSetContent(
    modifier: Modifier = Modifier,
    pagingPokemonSet: LazyPagingItems<PokemonSet>,
    paddingValues: PaddingValues,
    onItemClick: (PokemonSet) -> Unit
) {
    Box(modifier = modifier.background(black)) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            contentPadding = paddingValues,
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            items(pagingPokemonSet.itemCount) { index ->
                val pokemonSet = pagingPokemonSet[index]
                pokemonSet?.let {
                    PokemonSetItem(
                        id = it.id,
                        name = it.name,
                        logo = it.images.logo,
                        symbol = it.images.symbol,
                        releaseDate = it.releaseDate
                    ) {

                    }
                }
            }
        }
    }
}
