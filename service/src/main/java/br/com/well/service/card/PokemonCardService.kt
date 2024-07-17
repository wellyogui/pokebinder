package br.com.well.service.card

import br.com.well.service.card.model.PokemonCard
import br.com.well.service.model.PokemonResponse
import br.com.well.service.set.model.SetResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonCardService {
    @GET("v2/cards")
    suspend fun getCards(@Query("page") page: Int,
                        @Query("pageSize") pageSize: Int,
                        @Query("q") set: String): PokemonResponse<PokemonCard>
}