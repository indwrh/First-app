package com.example.alchemistry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Science
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alchemistry.ui.screens.DashboardScreen
import com.example.alchemistry.ui.screens.ResourcesScreen
import com.example.alchemistry.ui.screens.TopicsScreen
import com.example.alchemistry.ui.screens.TrackerScreen
import com.example.alchemistry.ui.theme.ChemistryTheme
import com.example.alchemistry.viewmodel.AppScreen
import com.example.alchemistry.viewmodel.ChemistryViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: ChemistryViewModel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ChemistryTheme {
                val context = LocalContext.current
                val uiState by viewModel.uiState.collectAsState()

                // Handle system back navigation to Dashboard
                BackHandler(enabled = uiState.currentScreen != AppScreen.Dashboard) {
                    viewModel.selectScreen(AppScreen.Dashboard)
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = {
                            TopAppBar(
                                title = {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(36.dp)
                                                .clip(RoundedCornerShape(10.dp))
                                                .background(
                                                    Brush.linearGradient(
                                                        listOf(Color(0xFF3B82F6), Color(0xFF8B5CF6))
                                                    )
                                                ),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Science,
                                                contentDescription = null,
                                                tint = Color.White,
                                                modifier = Modifier.size(20.dp)
                                            )
                                        }

                                        Column {
                                            Text(
                                                text = "A/L Chemistry",
                                                fontSize = 17.sp,
                                                fontWeight = FontWeight.ExtraBold,
                                                color = MaterialTheme.colorScheme.onSurface
                                            )
                                            Text(
                                                text = "MASTER HUB",
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.Black,
                                                letterSpacing = 1.sp,
                                                color = MaterialTheme.colorScheme.primary
                                            )
                                        }
                                    }
                                },
                                colors = TopAppBarDefaults.topAppBarColors(
                                    containerColor = MaterialTheme.colorScheme.surface
                                )
                            )
                        },
                        bottomBar = {
                            NavigationBar(
                                modifier = Modifier
                                    .testTag("bottom_nav_bar")
                                    .windowInsetsPadding(WindowInsets.navigationBars),
                                containerColor = MaterialTheme.colorScheme.surface
                            ) {
                                NavigationBarItem(
                                    selected = uiState.currentScreen == AppScreen.Dashboard,
                                    onClick = { viewModel.selectScreen(AppScreen.Dashboard) },
                                    icon = {
                                        Icon(Icons.Default.Home, contentDescription = "Home")
                                    },
                                    label = { Text("Home", fontSize = 11.sp, fontWeight = FontWeight.SemiBold) },
                                    modifier = Modifier.testTag("nav_item_home")
                                )

                                NavigationBarItem(
                                    selected = uiState.currentScreen == AppScreen.Topics,
                                    onClick = { viewModel.selectScreen(AppScreen.Topics) },
                                    icon = {
                                        Icon(Icons.Default.Science, contentDescription = "Topics")
                                    },
                                    label = { Text("Topics", fontSize = 11.sp, fontWeight = FontWeight.SemiBold) },
                                    modifier = Modifier.testTag("nav_item_topics")
                                )

                                NavigationBarItem(
                                    selected = uiState.currentScreen == AppScreen.Resources,
                                    onClick = { viewModel.selectScreen(AppScreen.Resources) },
                                    icon = {
                                        Icon(Icons.AutoMirrored.Filled.MenuBook, contentDescription = "Resources")
                                    },
                                    label = { Text("Resources", fontSize = 11.sp, fontWeight = FontWeight.SemiBold) },
                                    modifier = Modifier.testTag("nav_item_resources")
                                )

                                NavigationBarItem(
                                    selected = uiState.currentScreen == AppScreen.Tracker,
                                    onClick = { viewModel.selectScreen(AppScreen.Tracker) },
                                    icon = {
                                        Icon(Icons.Default.TrendingUp, contentDescription = "Tracker")
                                    },
                                    label = { Text("Tracker", fontSize = 11.sp, fontWeight = FontWeight.SemiBold) },
                                    modifier = Modifier.testTag("nav_item_tracker")
                                )
                            }
                        }
                    ) { innerPadding ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                        ) {
                            when (uiState.currentScreen) {
                                AppScreen.Dashboard -> {
                                    DashboardScreen(
                                        uiState = uiState,
                                        onNavigateToTopics = { viewModel.selectScreen(AppScreen.Topics) },
                                        onNavigateToResources = { viewModel.selectScreen(AppScreen.Resources) },
                                        onSelectCategory = { catId ->
                                            viewModel.filterAndNavigateToTopics(catId)
                                        }
                                    )
                                }
                                AppScreen.Topics -> {
                                    TopicsScreen(
                                        uiState = uiState,
                                        onSearchQueryChange = { q -> viewModel.setSearchQuery(q) },
                                        onCategoryFilterChange = { cat -> viewModel.setCategoryFilter(cat) },
                                        onToggleLesson = { id -> viewModel.toggleLesson(id) },
                                        onOpenUrl = { url -> viewModel.openUrl(context, url) }
                                    )
                                }
                                AppScreen.Resources -> {
                                    ResourcesScreen(
                                        onOpenUrl = { url -> viewModel.openUrl(context, url) }
                                    )
                                }
                                AppScreen.Tracker -> {
                                    TrackerScreen(
                                        uiState = uiState,
                                        onToggleLesson = { id -> viewModel.toggleLesson(id) },
                                        onResetProgress = { viewModel.resetProgress() }
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
