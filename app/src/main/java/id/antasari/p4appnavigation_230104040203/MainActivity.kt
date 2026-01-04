package id.antasari.p4appnavigation_230104040203

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import id.antasari.p4appnavigation_230104040203.ui.theme.P4appnavigation_230104040203Theme
import androidx.compose.material3.Surface
import id.antasari.p4appnavigation_230104040203.nav.NavGraph


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Theme bawaan template (mis: P4appnavigation_230104040203Theme
            id.antasari.p4appnavigation_230104040203.ui.theme.P4appnavigation_230104040203Theme {
                Surface(modifier = Modifier.fillMaxSize()){
                    NavGraph()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    P4appnavigation_230104040203Theme {
        Greeting("Android")
    }
}