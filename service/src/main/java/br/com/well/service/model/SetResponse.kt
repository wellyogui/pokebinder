package br.com.well.service.model


data class PokemonResponse<T>(
    val count: Int,
    val data: List<T>,
    val page: Int,
    val pageSize: Int,
    val totalCount: Int
)