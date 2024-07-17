package br.com.well.pokebinder.pokemon_set_feature.presentation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.paging.compose.collectAsLazyPagingItems
import br.com.well.pokebinder.pokemon_set_feature.presentation.components.PokemonSetContent
import br.com.well.pokebinder.pokemon_set_feature.presentation.state.PokemonSetListUiState
import br.com.well.pokebinder.ui.theme.black
import br.com.well.pokebinder.ui.theme.red
import br.com.well.pokebinder.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonSetListScreen(
    uiState: PokemonSetListUiState,
    navigateToPokemonSetDetails: (String, String) -> Unit
) {

    val pokemonSetList = uiState.pokemonSetList.collectAsLazyPagingItems()

    Scaffold(topBar = {
        TopAppBar(title = {
            Text(text = "Sets")
        }, colors = TopAppBarDefaults.topAppBarColors(containerColor = red, titleContentColor = white))
    }, content = { paddingValues ->
        PokemonSetContent(pagingPokemonSet = pokemonSetList,
            paddingValues = paddingValues) {
            navigateToPokemonSetDetails(it.id, it.name)
        }
    })
}

