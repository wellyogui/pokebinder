package br.com.well.pokebinder.pokemon_card_list_feature.data.source

import br.com.well.pokebinder.core.paging.PokemonCardPagingSource
import br.com.well.pokebinder.pokemon_card_list_feature.domain.source.PokemonCardListRemoteDataSource
import br.com.well.service.card.PokemonCardService
import br.com.well.service.card.model.PokemonCard
import br.com.well.service.model.PokemonResponse
import javax.inject.Inject

class PokemonCardListListRemoteDataSourceImpl @Inject constructor(
    private val service: PokemonCardService
): PokemonCardListRemoteDataSource {
    override fun getPokemonCardPagingSource(set: String): PokemonCardPagingSource {
        return PokemonCardPagingSource(set, this)
    }

    override suspend fun getCards(set: String, page: Int): PokemonResponse<PokemonCard> {
        return service.getCards(page, 10, set)
    }
}