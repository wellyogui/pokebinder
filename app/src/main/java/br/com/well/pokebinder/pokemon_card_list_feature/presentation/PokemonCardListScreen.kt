package br.com.well.pokebinder.pokemon_card_list_feature.presentation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.paging.compose.collectAsLazyPagingItems
import br.com.well.pokebinder.pokemon_card_list_feature.presentation.components.PokemonCardListContent
import br.com.well.pokebinder.pokemon_card_list_feature.presentation.state.PokemonCardListUiState
import br.com.well.pokebinder.ui.theme.red
import br.com.well.pokebinder.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonCardListScreen(
    title: String,
    id: String,
    uiState: PokemonCardListUiState,
    onFetch: (String) -> Unit,
    navigateToPokemonSetDetails: (Int) -> Unit
) {
    LaunchedEffect(id) { // onFetch will be called once when title changes
        onFetch(id)
    }
    val pokemonCardList = uiState.pokemonCardList.collectAsLazyPagingItems()
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(text = title)
        }, colors = TopAppBarDefaults.topAppBarColors(containerColor = red, titleContentColor = white))
    }, content = { paddingValues ->
        PokemonCardListContent(pagingPokemonCard = pokemonCardList, paddingValues = paddingValues) {

        }
    })
}
