package br.com.well.pokebinder.pokemon_set_feature.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import br.com.well.pokebinder.ui.presentation.common.ErrorScreen
import br.com.well.pokebinder.ui.presentation.common.LoadingView
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
                pokemonSet?.let { set ->
                    PokemonSetItem(
                        id = set.id,
                        name = set.name,
                        logo = set.images.logo,
                        symbol = set.images.symbol,
                        releaseDate = set.releaseDate
                    ) {
                        onItemClick(set)
                    }
                }
            }

            pagingPokemonSet.apply {
                when {
                    loadState.refresh is LoadState.Loading -> {
                        item(
                            span = {
                                GridItemSpan(maxLineSpan)
                            }
                        ) {
                            LoadingView()
                        }
                    }

                    loadState.append is LoadState.Loading -> {
                        item(
                            span = {
                                GridItemSpan(maxLineSpan)
                            }
                        ) {
                            LoadingView()
                        }
                    }

                    loadState.refresh is LoadState.Error -> {
                        item(
                            span = {
                                GridItemSpan(maxLineSpan)
                            }
                        ) {
                            ErrorScreen(message = "Verifique sua conexão com a internet") {
                                retry()
                            }
                        }
                    }

                    loadState.append is LoadState.Error -> {
                        item(
                            span = {
                                GridItemSpan(maxLineSpan)
                            }
                        ) {
                            ErrorScreen(message = "Verifique sua conexão com a internet") {
                                retry()
                            }
                        }
                    }
                }

            }
        }
    }
}
