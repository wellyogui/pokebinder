package br.com.well.pokebinder.pokemon_set_feature.domain.repository

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.well.service.set.model.PokemonSet
import kotlinx.coroutines.flow.Flow


interface PokemonSetListRepository {
    fun getSets(pagingConfig: PagingConfig): Flow<PagingData<PokemonSet>>
}