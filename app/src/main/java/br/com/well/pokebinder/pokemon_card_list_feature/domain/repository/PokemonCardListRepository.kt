package br.com.well.pokebinder.pokemon_card_list_feature.domain.repository

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.well.service.card.model.PokemonCard
import kotlinx.coroutines.flow.Flow

interface PokemonCardListRepository {
    fun getCards(set: String, pagingConfig: PagingConfig): Flow<PagingData<PokemonCard>>
}