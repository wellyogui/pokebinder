package br.com.well.pokebinder.pokemon_card_list_feature.domain.source

import br.com.well.pokebinder.core.paging.PokemonCardPagingSource
import br.com.well.service.card.model.PokemonCard
import br.com.well.service.model.PokemonResponse

interface PokemonCardListRemoteDataSource {
    fun getPokemonCardPagingSource(set: String): PokemonCardPagingSource
    suspend fun getCards(set: String, page: Int): PokemonResponse<PokemonCard>
}