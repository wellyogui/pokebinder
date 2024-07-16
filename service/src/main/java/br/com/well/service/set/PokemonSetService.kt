package br.com.well.service.set

import br.com.well.service.set.model.PokemonSet
import br.com.well.service.set.model.SetResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonSetService {

    @GET("v2/sets")
    suspend fun getSets(@Query("page") page: Int,
                        @Query("pageSize") pageSize: Int,
                        @Query("orderBy") orderBy: String = "-releaseDate,id"): SetResponse

    @GET("v2/sets/{id}")
    suspend fun getSet(@Path("id") id: String): PokemonSet

}