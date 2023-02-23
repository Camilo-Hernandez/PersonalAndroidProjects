package com.example.composequadrants

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrants.ui.theme.ComposeQuadrantsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PreviewMyComposeQuadrant()
                }
            }
        }
    }
}


@Composable
@Preview(
    showBackground = true, showSystemUi = true, device = Devices.NEXUS_5, locale = "English"
)
fun PreviewMyComposeQuadrant() {
    ComposeQuadrant()
}

@Composable
fun ComposeQuadrant() {
    Column(Modifier.fillMaxSize()) {
        Row(
            Modifier.weight(1f)
        ) {
            SingleQuadrant(
                Color.Green,
                "Text composable",
                "Displays text and follows Material Design guidelines.",
                Modifier.weight(1f)
            )
            SingleQuadrant(
                Color.Yellow,
                "Image composable",
                "Creates a composable that layus out and draws a given Painter class object.",
                Modifier.weight(1f)
            )
        }

        Row(
            Modifier.weight(1f)
        ) {
            SingleQuadrant(
                Color.Cyan,
                "Row composable",
                "A layout composable that places its children in a horizontal sequence.",
                Modifier.weight(1f)
            )
            SingleQuadrant(
                Color.LightGray,
                "Column composable",
                "A layout composable that places its children in a vertical sequence.",
                Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun SingleQuadrant(backgroundColor: Color, title: String, description: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(text = description, textAlign = TextAlign.Justify)
    }
}
