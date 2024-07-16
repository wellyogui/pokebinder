package br.com.well.pokebinder.pokemon_set_feature.presentation.state

import androidx.paging.PagingData
import br.com.well.service.set.model.PokemonSet
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class PokemonSetListUiState(val pokemonSetList: Flow<PagingData<PokemonSet>> = emptyFlow()) {
}