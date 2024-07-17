package br.com.well.pokebinder.ui.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.well.pokebinder.pokemon_card_list_feature.presentation.PokemonCardListScreen
import br.com.well.pokebinder.pokemon_card_list_feature.presentation.PokemonCardListViewModel
import br.com.well.pokebinder.pokemon_set_feature.presentation.PokemonSetListScreen
import br.com.well.pokebinder.pokemon_set_feature.presentation.PokemonSetListViewModel

@Composable
fun NavigationGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController,
        startDestination = BottomNavItem.PokemonSets.route) {
        composable(BottomNavItem.PokemonSets.route) {
            val viewModel = hiltViewModel<PokemonSetListViewModel>()
            val uiState = viewModel.uiState
            PokemonSetListScreen(uiState = uiState, navigateToPokemonSetDetails = { id, name ->
                navHostController.navigate(BottomNavItem.PokemonCardList.createRoute(setId = id, setTitle = name))
            })
        }
        composable(
            route = BottomNavItem.PokemonCardList.route + "/{${BottomNavItem.PokemonCardList.SET_ID_ARGUMENT_KEY}}" + "/{${BottomNavItem.PokemonCardList.SET_TITLE_ARGUMENT_KEY}}", // Add argument to route
            arguments = listOf(navArgument(BottomNavItem.PokemonCardList.SET_ID_ARGUMENT_KEY) {
                type = NavType.StringType
            }, navArgument(BottomNavItem.PokemonCardList.SET_TITLE_ARGUMENT_KEY) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val setId = backStackEntry.arguments?.getString(BottomNavItem.PokemonCardList.SET_ID_ARGUMENT_KEY) ?: ""
            val setTitle = backStackEntry.arguments?.getString(BottomNavItem.PokemonCardList.SET_TITLE_ARGUMENT_KEY) ?: ""
            val viewModel = hiltViewModel<PokemonCardListViewModel>()
            val fetch = viewModel::getCardsBySetId
            val uiState = viewModel.uiState

            PokemonCardListScreen(uiState = uiState, title = setTitle, id = setId, onFetch = fetch, navigateToPokemonSetDetails = {
                // ... (your navigation logic)
            })
        }
    }
}

@Preview
@Composable
private fun NavigationGraphPreview() {
    NavigationGraph(navHostController = rememberNavController())
}