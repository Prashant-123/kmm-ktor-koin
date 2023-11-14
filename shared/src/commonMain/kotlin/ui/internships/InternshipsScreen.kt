@file:OptIn(ExperimentalResourceApi::class)

package ui.internships

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import app.cash.paging.compose.collectAsLazyPagingItems
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ui.PagingListUI

class InternshipsScreen : KoinComponent {
    private val viewModel: InternshipViewModel by inject()

    @Composable
    fun content() {
        val result by rememberUpdatedState(viewModel.internships.collectAsLazyPagingItems())
        return Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Internships") },
                    elevation = 0.dp,
                    navigationIcon = {
                        IconButton(onClick = { println("Drawer clicked") }) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                        }
                    },
                    actions = {
                        IconButton(onClick = { println("Search Internships!") }) {
                            Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                        }
                    },
                    backgroundColor = Color.White
                )
            },
            drawerContent = { /*Drawer content*/ },
            content = { PagingListUI(data = result, content = { InternshipCard(it) }) },
        )
    }
}