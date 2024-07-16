package br.com.well.pokebinder.pokemon_set_feature.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.well.pokebinder.pokemon_set_feature.domain.repository.PokemonSetListRepository
import br.com.well.pokebinder.pokemon_set_feature.domain.source.PokemonSetListRemoteDataSource
import br.com.well.service.set.model.PokemonSet
import kotlinx.coroutines.flow.Flow


class PokemonSetListRepositoryImpl(private val remoteDataSource: PokemonSetListRemoteDataSource):
    PokemonSetListRepository {
    override fun getSets(pagingConfig: PagingConfig): Flow<PagingData<PokemonSet>> {
        return Pager(config = pagingConfig, pagingSourceFactory = {
            remoteDataSource.getPokemonSetPagingSource()
        }).flow
    }

}