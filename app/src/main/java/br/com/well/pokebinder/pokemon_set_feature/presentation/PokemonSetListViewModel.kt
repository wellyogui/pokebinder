package br.com.well.pokebinder.pokemon_set_feature.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import br.com.well.pokebinder.pokemon_set_feature.domain.usecase.GetPokemonSetListUseCase
import br.com.well.pokebinder.pokemon_set_feature.presentation.state.PokemonSetListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonSetListViewModel @Inject constructor(
    private val getPokemonSetListUseCase: GetPokemonSetListUseCase
): ViewModel() {
    var uiState by mutableStateOf(PokemonSetListUiState())
        private set

    init {
        val pokemonSetList = getPokemonSetListUseCase()
            .cachedIn(viewModelScope)

        uiState = uiState.copy(pokemonSetList = pokemonSetList)
    }
}