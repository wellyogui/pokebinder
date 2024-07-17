package br.com.well.pokebinder.pokemon_card_list_feature.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import br.com.well.pokebinder.pokemon_card_list_feature.domain.usecase.GetPokemonCardListUseCase
import br.com.well.pokebinder.pokemon_card_list_feature.presentation.state.PokemonCardListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PokemonCardListViewModel @Inject constructor(private val getCardListUseCase: GetPokemonCardListUseCase): ViewModel() {
    var uiState by mutableStateOf(PokemonCardListUiState())
        private set

    fun getCardsBySetId(setId: String) {
        val cardList = getCardListUseCase(setId).cachedIn(viewModelScope)

        uiState = uiState.copy(pokemonCardList = cardList)
    }
}