package id.antasari.p4appnavigation_230104040203.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import id.antasari.p4appnavigation_230104040203.nav.Route

/* =======================
   STEP 1
   ======================= */
@Composable
fun Step1Screen(nav: NavController) {
    StepLayout(
        step = 1,
        current = "Step 1",
        previous = "Home",
        onNextText = "Continue to Step 2",
        onNext = { nav.navigate(Route.Step2.path) }
    )
}

/* =======================
   STEP 2
   ======================= */
@Composable
fun Step2Screen(nav: NavController) {
    StepLayout(
        step = 2,
        current = "Step 2",
        previous = "Step 1",
        onNextText = "Continue to Step 3",
        onNext = { nav.navigate(Route.Step3.path) },
        onBack = { nav.popBackStack() }
    )
}

/* =======================
   STEP 3
   ======================= */
@Composable
fun Step3Screen(nav: NavController) {
    StepLayout(
        step = 3,
        current = "Step 3",
        previous = "Step 2",
        onNextText = "Back to Home",
        onNext = {
            nav.navigate(Route.Home.path) {
                popUpTo(Route.Home.path) { inclusive = true }
            }
        },
        onBack = { nav.popBackStack() }
    )
}

/* =======================
   SHARED UI
   ======================= */
@Composable
private fun StepLayout(
    step: Int,
    current: String,
    previous: String,
    onNextText: String,
    onNext: () -> Unit,
    onBack: (() -> Unit)? = null
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        /* ===== Stack Info ===== */
        Card {
            Column(
                Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("Current Stack State", fontWeight = FontWeight.Bold)
                Text("Stack depth (approx): $step")
                Text("Current screen: $current")
                Text("Previous: $previous")
            }
        }

        /* ===== Action Button ===== */
        Button(
            onClick = onNext,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(onNextText)
        }

        /* ===== Navigation Steps ===== */
        Card {
            Column(
                Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text("Navigation Steps", fontWeight = FontWeight.Bold)
                Text(if (step >= 1) "✓ First Step" else "• First Step")
                Text(if (step >= 2) "✓ Second Step" else "• Second Step")
                Text(if (step >= 3) "✓ Final Step" else "• Final Step")
            }
        }

        /* ===== Concepts ===== */
        Card {
            Column(
                Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text("Back Stack Concepts", fontWeight = FontWeight.Bold)
                Text("• Navigate push → tambah ke stack")
                Text("• Back pop → hapus paling atas")
                Text("• popUpTo → bersihkan stack")
            }
        }

        /* ===== Back Button ===== */
        if (onBack != null) {
            OutlinedButton(
                onClick = onBack,
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Back")
            }
        }
    }
}
