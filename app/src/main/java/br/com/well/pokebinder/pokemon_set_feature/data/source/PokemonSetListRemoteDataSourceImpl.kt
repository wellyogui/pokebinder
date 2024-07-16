package br.com.well.pokebinder.pokemon_set_feature.data.source

import br.com.well.pokebinder.core.paging.PokemonSetPagingSource
import br.com.well.pokebinder.pokemon_set_feature.domain.source.PokemonSetListRemoteDataSource
import br.com.well.service.set.PokemonSetService
import br.com.well.service.set.model.SetResponse
import javax.inject.Inject

class PokemonSetListRemoteDataSourceImpl @Inject constructor(
    private val service: PokemonSetService
): PokemonSetListRemoteDataSource {
    override fun getPokemonSetPagingSource(): PokemonSetPagingSource {
        return PokemonSetPagingSource(this)
    }

    override suspend fun getSets(page: Int): SetResponse {
        return service.getSets(page, 10)
    }
}