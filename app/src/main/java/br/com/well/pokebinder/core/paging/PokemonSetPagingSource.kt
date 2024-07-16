package br.com.well.pokebinder.core.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.well.pokebinder.pokemon_set_feature.domain.source.PokemonSetListRemoteDataSource
import br.com.well.service.set.model.PokemonSet
import coil.network.HttpException
import java.io.IOException

class PokemonSetPagingSource(private val remoteDataSource: PokemonSetListRemoteDataSource): PagingSource<Int, PokemonSet>() {
    companion object {
        private const val LIMIT = 10
    }

    override fun getRefreshKey(state: PagingState<Int, PokemonSet>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(LIMIT) ?: anchorPage?.nextKey?.minus(
                LIMIT
            )
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokemonSet> {
        return try {
            val pageNumber = params.key ?: 1
            val response = remoteDataSource.getSets(pageNumber)
            val pokemonSet = response.pokemonSets
            LoadResult.Page(
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