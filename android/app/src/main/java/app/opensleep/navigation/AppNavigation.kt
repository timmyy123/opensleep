package app.opensleep.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.ime
import androidx.navigation.navArgument
import app.opensleep.data.local.SleepDatabase
import app.opensleep.data.repository.ChatRepository
import app.opensleep.data.repository.SleepRepository
import app.opensleep.domain.HealthSyncManager
import app.opensleep.domain.LiteRtManager
import app.opensleep.domain.ModelDownloadManager
import app.opensleep.ui.screens.*
import app.opensleep.ui.theme.IndigoAccent
import app.opensleep.ui.theme.NavyDeep
import app.opensleep.ui.theme.TextSecondary
import app.opensleep.viewmodel.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.annotation.StringRes
import app.opensleep.R

sealed class Screen(val route: String, @StringRes val labelId: Int, val icon: ImageVector) {
    object Home : Screen("home", R.string.menu_sleep, Icons.Default.Bedtime)
    object History : Screen("history", R.string.menu_history, Icons.Default.BarChart)
    object Chat : Screen("chat", R.string.menu_chat, Icons.Default.AutoAwesome)
    object Settings : Screen("settings", R.string.menu_settings, Icons.Default.Settings)
    object Detail : Screen("detail/{sessionId}", R.string.menu_settings, Icons.Default.Info)
}

@Composable
fun AppNavigation() {
    val context = LocalContext.current
    val db = remember { SleepDatabase.getInstance(context) }
    val sleepRepo = remember { SleepRepository(db.sleepSessionDao()) }
    val chatRepo = remember { ChatRepository(db.chatDao()) }
    val healthSync = remember { HealthSyncManager(context) }
    val liteRt = remember { LiteRtManager(context) }
    val downloadMgr = remember { ModelDownloadManager(context) }

    val homeVm = remember { HomeViewModel(sleepRepo, healthSync) }
    val historyVm = remember { HistoryViewModel(sleepRepo, healthSync) }
    val chatVm = remember { AiChatViewModel(chatRepo, sleepRepo, liteRt, downloadMgr) }
    val settingsVm = remember { SettingsViewModel(context.applicationContext as android.app.Application, downloadMgr) }

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val bottomTabs = listOf(Screen.Home, Screen.History, Screen.Chat, Screen.Settings)
    val isImeVisible = WindowInsets.ime.getBottom(androidx.compose.ui.platform.LocalDensity.current) > 0
    val showBottomBar = currentRoute in bottomTabs.map { it.route } && !isImeVisible

    Scaffold(
        containerColor = NavyDeep,
        bottomBar = {
            if (showBottomBar) {
                NavigationBar(containerColor = NavyDeep.copy(alpha = 0.95f)) {
                    bottomTabs.forEach { screen ->
                        NavigationBarItem(
                            selected = currentRoute == screen.route,
                            onClick = {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = { Icon(screen.icon, stringResource(screen.labelId)) },
                            label = { Text(stringResource(screen.labelId)) },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = IndigoAccent,
                                selectedTextColor = IndigoAccent,
                                unselectedIconColor = TextSecondary,
                                unselectedTextColor = TextSecondary,
                                indicatorColor = IndigoAccent.copy(alpha = 0.15f)
                            )
                        )
                    }
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = androidx.compose.ui.Modifier
                .padding(padding)
                .consumeWindowInsets(padding)
        ) {
            composable(Screen.Home.route) { HomeScreen(homeVm) }
            composable(Screen.History.route) {
                HistoryScreen(historyVm) { sessionId ->
                    navController.navigate("detail/$sessionId")
                }
            }
            composable(Screen.Chat.route) {
                AiChatScreen(chatVm, onNavigateToSettings = {
                    navController.navigate(Screen.Settings.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                })
            }
            composable(Screen.Settings.route) { SettingsScreen(settingsVm) }
            composable(
                Screen.Detail.route,
                arguments = listOf(navArgument("sessionId") { type = NavType.StringType })
            ) { backStack ->
                val sessionId = backStack.arguments?.getString("sessionId") ?: return@composable
                var session by remember { mutableStateOf<app.opensleep.data.local.SleepSession?>(null) }
                LaunchedEffect(sessionId) {
                    session = sleepRepo.getSessionById(sessionId)
                }
                session?.let { SleepDetailScreen(it) { navController.popBackStack() } }
            }
        }
    }
}
