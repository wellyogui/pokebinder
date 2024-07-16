package br.com.well.pokebinder.ui.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.well.pokebinder.ui.theme.black
import br.com.well.pokebinder.ui.theme.lightGray
import br.com.well.pokebinder.ui.theme.redAlpha
import br.com.well.pokebinder.ui.theme.white

@Composable
fun BottomNavigationBar(
    navController: NavController, modifier: Modifier = Modifier
) {
    var selectedItem by remember {
        mutableIntStateOf(0)
    }
    val items = listOf(BottomNavItem.PokemonSets, BottomNavItem.Search)

    NavigationBar(containerColor = black) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(selected = selectedItem == index,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = white,
                    unselectedIconColor = lightGray,
                    selectedTextColor = white,
                    unselectedTextColor = lightGray,
                    indicatorColor = redAlpha
                ),
                label = { Text(item.title) },
                onClick = {
                    navController.navigate(item.route) {
                        launchSingleTop = true
                    }
                    selectedItem = index
                },
                icon = { Icon(imageVector = item.icon, contentDescription = "") })
        }
    }
}

@Preview
@Composable
private fun BottomNavigationBarPreview() {
    BottomNavigationBar(navController = rememberNavController())
}