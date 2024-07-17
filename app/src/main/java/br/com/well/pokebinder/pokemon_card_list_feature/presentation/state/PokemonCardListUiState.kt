package br.com.well.pokebinder.pokemon_card_list_feature.presentation.state

import androidx.paging.PagingData
import br.com.well.service.card.model.PokemonCard
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class PokemonCardListUiState(val pokemonCardList: Flow<PagingData<PokemonCard>> = emptyFlow())