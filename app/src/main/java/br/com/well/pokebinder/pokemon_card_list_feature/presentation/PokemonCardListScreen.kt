package br.com.well.pokebinder.pokemon_card_list_feature.presentation

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner.current
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
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
    val onBackPressedDispatcher = current?.onBackPressedDispatcher

    LaunchedEffect(id) {
        onFetch(id)
    }

    val pokemonCardList = uiState.pokemonCardList.collectAsLazyPagingItems()
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(text = title)
        }, colors = TopAppBarDefaults.topAppBarColors(containerColor = red, titleContentColor = white), navigationIcon = {
            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", modifier = Modifier.clickable {
                onBackPressedDispatcher?.onBackPressed()
            })
        })
    }, content = { paddingValues ->
        PokemonCardListContent(pagingPokemonCard = pokemonCardList, paddingValues = paddingValues) {

        }
    })
}
