package br.com.well.pokebinder.pokemon_set_feature.domain.source

import br.com.well.pokebinder.core.paging.PokemonSetPagingSource
import br.com.well.service.set.model.SetResponse

interface PokemonSetListRemoteDataSource {
    fun getPokemonSetPagingSource(): PokemonSetPagingSource
    suspend fun getSets(page: Int): SetResponse
}