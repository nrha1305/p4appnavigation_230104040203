package id.antasari.p4appnavigation_230104040203.nav

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import id.antasari.p4appnavigation_230104040203.R
import id.antasari.p4appnavigation_230104040203.screens.*
import java.net.URLDecoder
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraph() {
    val nav = rememberNavController()

    val currentRoute =
        nav.currentBackStackEntryAsState().value?.destination?.route

    Scaffold(
        topBar = {
            TopBar(
                title = currentTitle(nav),
                canNavigateBack = nav.previousBackStackEntry != null,
                onBack = { nav.popBackStack() },
                isHome = currentRoute == Route.Home.path
            )
        }
    ) { padding ->

        NavHost(
            navController = nav,
            startDestination = Route.Home.path,
            modifier = Modifier.padding(padding)
        ) {

            /* ================= HOME ================= */
            composable(Route.Home.path) {
                HomeScreen(nav)
            }

            /* ================= ACTIVITY A / B ================= */
            composable(Route.ActivityA.path) {
                ActivityAScreen(
                    onOpen = { nav.navigate(Route.ActivityB.path) }
                )
            }

            composable(Route.ActivityB.path) {
                ActivityBScreen()
            }

            /* ================= ACTIVITY C / D ================= */
            composable(Route.ActivityC.path) {
                ActivityCScreen(
                    onSend = { name, nim ->
                        nav.navigate(Route.ActivityD.make(name, nim))
                    }
                )
            }

            composable(
                route = Route.ActivityD.path,
                arguments = listOf(
                    navArgument("name") { type = NavType.StringType },
                    navArgument("studentId") { type = NavType.StringType }
                )
            ) { backStack ->
                val name = URLDecoder.decode(
                    backStack.arguments?.getString("name") ?: "",
                    "utf-8"
                )
                val nim = URLDecoder.decode(
                    backStack.arguments?.getString("studentId") ?: "",
                    "utf-8"
                )

                ActivityDScreen(
                    name = name,
                    nim = nim,
                    onResend = { nav.popBackStack() }
                )
            }

            /* ================= BACK STACK DEMO ================= */
            composable(Route.Step1.path) {
                Step1Screen(nav)
            }

            composable(Route.Step2.path) {
                Step2Screen(nav)
            }

            composable(Route.Step3.path) {
                Step3Screen(nav)
            }

            /* ================= HUB (BOTTOM NAV) ================= */
            navigation(
                startDestination = Route.HubDashboard.path,
                route = Route.Hub.path
            ) {

                composable(Route.HubDashboard.path) {
                    HubScreen(nav, HubTab.Dashboard)
                }

                composable(Route.HubMessages.path) {
                    HubScreen(nav, HubTab.Messages)
                }

                composable(Route.HubProfile.path) {
                    HubScreen(nav, HubTab.Profile)
                }

                composable(
                    route = Route.HubMsgDetail.path,
                    arguments = listOf(
                        navArgument("id") {
                            type = NavType.StringType
                        }
                    )
                ) { backStack ->
                    val id = backStack.arguments?.getString("id") ?: ""
                    MessageDetailScreen(
                        onBack = { nav.popBackStack() }
                    )
                }
            }
        }
    }
}

/* ================= TOP BAR ================= */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(
    title: String,
    canNavigateBack: Boolean,
    onBack: () -> Unit,
    isHome: Boolean
) {
    TopAppBar(
        title = {
            if (isHome) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(R.drawable.ic_navio),
                        contentDescription = "Navio",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = "Navio",
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            } else {
                Text(
                    text = title,
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.titleLarge
                )
            }
        },
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = onBack) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}

/* ================= TITLE HANDLER ================= */

@Composable
private fun currentTitle(nav: NavHostController): String {
    val route = nav.currentBackStackEntryAsState().value?.destination?.route ?: ""
    return when {
        route == Route.Step1.path -> "Step 1 of 3"
        route == Route.Step2.path -> "Step 2 of 3"
        route == Route.Step3.path -> "Step 3 of 3"
        route.startsWith("hub") -> "Activity + Fragment Hub"
        route.startsWith("activity_d") -> "Activity D - Data Display"
        route == Route.ActivityC.path -> "Activity C - Send Data"
        route == Route.ActivityA.path -> "Activity A"
        route == Route.ActivityB.path -> "Launched by Intent"
        else -> "Navigation Lab"
    }
}
