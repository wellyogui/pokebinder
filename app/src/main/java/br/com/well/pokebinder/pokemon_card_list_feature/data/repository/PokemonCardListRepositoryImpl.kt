package br.com.well.pokebinder.pokemon_card_list_feature.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.well.pokebinder.pokemon_card_list_feature.domain.repository.PokemonCardListRepository
import br.com.well.pokebinder.pokemon_card_list_feature.domain.source.PokemonCardListRemoteDataSource
import br.com.well.service.card.model.PokemonCard
import kotlinx.coroutines.flow.Flow

class PokemonCardListRepositoryImpl(private val remoteDataSource: PokemonCardListRemoteDataSource):
    PokemonCardListRepository {
    override fun getCards(set: String, pagingConfig: PagingConfig): Flow<PagingData<PokemonCard>> {
        return Pager(config = pagingConfig, pagingSourceFactory = {
            remoteDataSource.getPokemonCardPagingSource(set)
        }).flow
    }
}