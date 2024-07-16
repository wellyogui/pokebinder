package br.com.well.pokebinder.ui.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import br.com.well.pokebinder.ui.presentation.navigation.BottomNavigationBar
import br.com.well.pokebinder.ui.presentation.navigation.NavigationGraph

@Composable
fun MainScreen(navHostController: NavHostController) {
    Scaffold(bottomBar = {
        BottomNavigationBar(navController = navHostController)
    }, content = { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            NavigationGraph(navHostController = navHostController)
        }
    })
}