package br.com.well.pokebinder.pokemon_set_feature.di

import br.com.well.pokebinder.pokemon_set_feature.data.repository.PokemonSetListRepositoryImpl
import br.com.well.pokebinder.pokemon_set_feature.data.source.PokemonSetListRemoteDataSourceImpl
import br.com.well.pokebinder.pokemon_set_feature.domain.repository.PokemonSetListRepository
import br.com.well.pokebinder.pokemon_set_feature.domain.source.PokemonSetListRemoteDataSource
import br.com.well.pokebinder.pokemon_set_feature.domain.usecase.GetPokemonSetListUseCase
import br.com.well.pokebinder.pokemon_set_feature.domain.usecase.GetPokemonSetListUseCaseImpl
import br.com.well.service.set.PokemonSetService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PokemonSetFeature {

    @Provides
    @Singleton
    fun providePokemonSetListDataSource(service: PokemonSetService): PokemonSetListRemoteDataSource {
        return PokemonSetListRemoteDataSourceImpl(service)
    }

    @Provides
    @Singleton
    fun providePokemonSetListRepository(remoteDataSource: PokemonSetListRemoteDataSource): PokemonSetListRepository {
        return PokemonSetListRepositoryImpl(remoteDataSource)
    }

    @Provides
    @Singleton
    fun providePokemonSetListUseCase(repository: PokemonSetListRepository): GetPokemonSetListUseCase {
        return GetPokemonSetListUseCaseImpl(repository)
    }
}