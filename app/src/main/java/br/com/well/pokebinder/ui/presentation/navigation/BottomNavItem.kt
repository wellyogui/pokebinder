package br.com.well.pokebinder.ui.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DataArray
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector


const val POKEMON_CARD_LIST_ARGUMENT_KEY = "setId"
sealed class BottomNavItem(val title: String, val icon: ImageVector, val route: String) {
    data object PokemonSets : BottomNavItem(
        title = "Home",
        icon = Icons.Default.Home,
        route = "home_screen"
    )

    object Search: BottomNavItem(
        title = "Search",
        icon = Icons.Default.Search,
        route = "search_screen"
    )

    data object PokemonCardList : BottomNavItem(title = "", icon = Icons.Default.DataArray, route = "pokemon_card_list_screen") {
        const val SET_ID_ARGUMENT_KEY = "setId"
        const val SET_TITLE_ARGUMENT_KEY = "setTitle"
        fun createRoute(setId: String, setTitle: String) = "$route/$setId/$setTitle"
    }
}