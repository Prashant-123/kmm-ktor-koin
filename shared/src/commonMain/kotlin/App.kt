import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import ui.CoursesScreen
import ui.HomeScreen
import ui.internships.InternshipsScreen
import ui.JobsScreen
import ui.Screen

@Composable
fun App() {
    MaterialTheme {
        val screens = Screen.values()
        var selectedScreen by remember { mutableStateOf(screens.first()) }

        Scaffold(
            bottomBar = {
                BottomNavigation(
                    backgroundColor = Color.White,
                    modifier = Modifier.height(64.dp)
                ) {
                    screens.forEach { screen ->
                        BottomNavigationItem(
                            modifier = Modifier.background(Color.White),
                            selectedContentColor = ui.theme.Color.textOnPrimary,
                            unselectedContentColor = Color.Gray,
                            icon = {
                                Icon(
                                    imageVector = getIconForScreen(screen),
                                    contentDescription = screen.textValue
                                )
                            },
                            label = { Text(screen.textValue) },
                            selected = screen == selectedScreen,
                            onClick = { selectedScreen = screen },
                        )
                    }
                }
            },
            content = { getScreen(selectedScreen) }
        )
    }
}

@Composable
fun getIconForScreen(screen: Screen): ImageVector {
    return when (screen) {
        Screen.INTERNSHIPS -> Icons.Default.AccountBox
        Screen.JOBS -> Icons.Default.Add
        Screen.COURSES -> Icons.Default.Notifications
        else -> Icons.Default.Home
    }
}

@Composable
fun getScreen(selectedScreen: Screen) = when (selectedScreen) {
    Screen.INTERNSHIPS -> InternshipsScreen().content()
    Screen.JOBS -> JobsScreen()
    Screen.COURSES -> CoursesScreen()
    else -> HomeScreen()
}