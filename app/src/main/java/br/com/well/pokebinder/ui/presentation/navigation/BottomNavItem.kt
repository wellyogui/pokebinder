package br.com.well.pokebinder.ui.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector


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
}