package id.antasari.p4appnavigation_230104040203.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.DirectionsRun
import androidx.compose.material.icons.filled.Layers
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import id.antasari.p4appnavigation_230104040203.nav.Route

@Composable
fun HomeScreen(nav: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text(
            text = "Navigasi Studio",
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = "Interactive demos for learning Activity & Fragment navigation",
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )

        Spacer(modifier = Modifier.height(16.dp))

        MenuCard(
            title = "Start Activity",
            desc = "Launch a new Activity using explicit Intent",
            icon = Icons.Default.DirectionsRun,
            onClick = { nav.navigate(Route.ActivityA.path) }
        )

        MenuCard(
            title = "Send Data",
            desc = "Pass data between Activities using Intent extras",
            icon = Icons.Default.Send,
            onClick = { nav.navigate(Route.ActivityC.path) }
        )

        MenuCard(
            title = "Back Stack",
            desc = "Understand how Android manages Activity stack",
            icon = Icons.Default.Layers,
            onClick = { nav.navigate(Route.Step1.path) }
        )

        MenuCard(
            title = "Activity + Fragment",
            desc = "Bottom navigation with multiple fragments",
            icon = Icons.Default.AutoAwesome,
            onClick = { nav.navigate(Route.Hub.path) }
        )
    }
}

@Composable
private fun MenuCard(
    title: String,
    desc: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = title,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = desc,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = onClick,
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Try Demo")
            }
        }
    }
}
