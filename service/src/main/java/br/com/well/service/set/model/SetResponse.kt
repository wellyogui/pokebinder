package br.com.well.service.set.model

import com.google.gson.annotations.SerializedName

data class SetResponse(
    val count: Int,
    @SerializedName("data")
    val pokemonSets: List<PokemonSet>,
    val page: Int,
    val pageSize: Int,
    val totalCount: Int
)