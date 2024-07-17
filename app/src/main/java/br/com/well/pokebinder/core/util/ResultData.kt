package br.com.well.pokebinder.core.util

sealed class ResultData<out T> {
    object Loading: ResultData<Nothing>()
    data class Success<out T>(val data: T) : ResultData<T>()
    data class Error(val exception: Exception) : ResultData<Nothing>()
}