package br.com.well.pokebinder.ui.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.well.pokebinder.pokemon_set_feature.presentation.PokemonSetListScreen
import br.com.well.pokebinder.pokemon_set_feature.presentation.PokemonSetListViewModel

@Composable
fun NavigationGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController,
        startDestination = BottomNavItem.PokemonSets.route) {
        composable(BottomNavItem.PokemonSets.route) {
            val viewModel = hiltViewModel<PokemonSetListViewModel>()
            val uiState = viewModel.uiState
            PokemonSetListScreen(uiState = uiState) {

            }
        }
    }
}