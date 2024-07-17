package br.com.well.pokebinder.core.paging

import androidx.paging.PagingSource
import androidx.paging.PagingSource.LoadResult.Page
import androidx.paging.PagingState
import br.com.well.pokebinder.pokemon_card_list_feature.domain.source.PokemonCardListRemoteDataSource
import br.com.well.service.card.model.PokemonCard
import coil.network.HttpException
import java.io.IOException

class PokemonCardPagingSource(private val set: String, private val remoteDataSource: PokemonCardListRemoteDataSource): PagingSource<Int, PokemonCard>() {
    companion object {
        private const val LIMIT = 10
    }

    override fun getRefreshKey(state: PagingState<Int, PokemonCard>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(LIMIT) ?: anchorPage?.nextKey?.minus(
                LIMIT
            )
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokemonCard> {
        return try {
            val pageNumber = params.key ?: 1
            val response = remoteDataSource.getCards(set ,pageNumber)
            val pokemonSet = response.data
            Page(
                data = pokemonSet,
                prevKey = if (pageNumber == 1) null else pageNumber - 1,
                nextKey = if (pokemonSet.isEmpty()) null else pageNumber + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

}