package br.com.well.pokebinder.pokemon_card_list_feature.di

import br.com.well.pokebinder.pokemon_card_list_feature.data.repository.PokemonCardListRepositoryImpl
import br.com.well.pokebinder.pokemon_card_list_feature.data.source.PokemonCardListListRemoteDataSourceImpl
import br.com.well.pokebinder.pokemon_card_list_feature.domain.repository.PokemonCardListRepository
import br.com.well.pokebinder.pokemon_card_list_feature.domain.source.PokemonCardListRemoteDataSource
import br.com.well.pokebinder.pokemon_card_list_feature.domain.usecase.GetPokemonCardListUseCase
import br.com.well.pokebinder.pokemon_card_list_feature.domain.usecase.GetPokemonCardListUseCaseImpl
import br.com.well.service.card.PokemonCardService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PokemonCardListFeature {

    @Provides
    @Singleton
    fun providePokemonCardListDataSource(service: PokemonCardService): PokemonCardListRemoteDataSource {
        return PokemonCardListListRemoteDataSourceImpl(service)
    }

    @Provides
    @Singleton
    fun providePokemonCardListRepository(remoteDataSource: PokemonCardListRemoteDataSource): PokemonCardListRepository {
        return PokemonCardListRepositoryImpl(remoteDataSource)
    }

    @Provides
    @Singleton
    fun providePokemonCardListUseCase(repository: PokemonCardListRepository): GetPokemonCardListUseCase {
        return GetPokemonCardListUseCaseImpl(repository)
    }
}