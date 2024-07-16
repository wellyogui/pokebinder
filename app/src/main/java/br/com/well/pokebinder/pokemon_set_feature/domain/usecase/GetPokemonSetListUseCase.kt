package br.com.well.pokebinder.pokemon_set_feature.domain.usecase

import android.text.PrecomputedText.Params
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.well.pokebinder.pokemon_set_feature.domain.repository.PokemonSetListRepository
import br.com.well.service.set.model.PokemonSet
import br.com.well.service.set.model.SetResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetPokemonSetListUseCase {
    operator fun invoke(): Flow<PagingData<PokemonSet>>
}

class GetPokemonSetListUseCaseImpl @Inject constructor(
    private val pokemonSetRepository: PokemonSetListRepository
): GetPokemonSetListUseCase {
    override fun invoke(): Flow<PagingData<PokemonSet>> {
        return pokemonSetRepository.getSets(
            pagingConfig = PagingConfig(
                pageSize = 10,
                initialLoadSize = 10
            )
        )
    }

}