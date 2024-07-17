package br.com.well.pokebinder.pokemon_card_list_feature.domain.usecase

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.well.pokebinder.pokemon_card_list_feature.domain.repository.PokemonCardListRepository
import br.com.well.service.card.model.PokemonCard
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetPokemonCardListUseCase {
    operator fun invoke(set: String): Flow<PagingData<PokemonCard>>
}

class GetPokemonCardListUseCaseImpl @Inject constructor(
    private val pokemonCardRepository: PokemonCardListRepository
): GetPokemonCardListUseCase {
    override fun invoke(set: String): Flow<PagingData<PokemonCard>> {
        return pokemonCardRepository.getCards(
            "set.id:$set",
            pagingConfig = PagingConfig(
                pageSize = 10,
                initialLoadSize = 10
            )
        )
    }

}