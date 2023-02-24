package com.example.jetpackcomposecatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecatalog.ui.theme.JetpackComposeCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    MyStateExample()
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeCatalogTheme {
        MyStateExample()
    }
}

@Composable
fun MyStateExample() {
    // remember guarda el estado cuando el composable se recompone pero no cuando la activity se destruye y vuelve a crearse
    // Se utiliza by para no tener que usar la propiedad counter.value que tendría que llamarse siempre para cambiar el valor del mutable state
    // para usar el by hay que importar getValue y setValue
    var counter by rememberSaveable {
        mutableStateOf(0)
    }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter++ }) {
            Text(text = "Presióname")
        }

        Text(text = "He sido pulsado $counter veces")
    }
}


@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Yellow),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Texto en el primer box")
        }
        MySpacer(size = 30)
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color.Red),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Texto en el box rojo")
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color.Green), contentAlignment = Alignment.Center
            ) {
                Text(text = "Hola, soy el mejor Camilo del mundo", textAlign = TextAlign.Center)
            }
        }
        MySpacer(size = 30)
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Texto en el box magenta")
        }
    }
}

@Composable
fun MySpacer(size: Int) {
    Spacer(modifier = Modifier.height(size.dp))
}

@Composable
fun MyRow() {
    /*
    Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = "Ejemplo 1")
        Text(text = "Ejemplo 2")
        Text(text = "Ejemplo 3")
    }
    */
    Row(
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Ejemplo 1", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 2", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 3", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 4", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 5", modifier = Modifier.width(100.dp))
    }
}

@Composable
fun MyColumn() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Ejemplo1", modifier = Modifier
                .background(Color.Yellow)
                .height(100.dp)
                .fillMaxWidth()
        )
        Text(
            text = "Ejemplo1", modifier = Modifier
                .background(Color.Yellow)
                .height(100.dp)
                .fillMaxWidth()
        )
        Text(
            text = "Ejemplo1", modifier = Modifier
                .background(Color.Yellow)
                .height(100.dp)
                .fillMaxWidth()
        )
        Text(
            text = "Ejemplo1", modifier = Modifier
                .background(Color.Yellow)
                .height(100.dp)
                .fillMaxWidth()
        )
        Text(
            text = "Ejemplo1", modifier = Modifier
                .background(Color.Yellow)
                .height(100.dp)
                .fillMaxWidth()
        )
        Text(
            text = "Ejemplo1", modifier = Modifier
                .background(Color.Yellow)
                .height(100.dp)
                .fillMaxWidth()
        )
        Text(
            text = "Ejemplo1", modifier = Modifier
                .background(Color.Yellow)
                .height(100.dp)
                .fillMaxWidth()
        )
        Text(
            text = "Ejemplo1", modifier = Modifier
                .background(Color.Yellow)
                .height(100.dp)
                .fillMaxWidth()
        )
        Text(
            text = "Ejemplo4", modifier = Modifier.background(Color.Yellow)
        ) // .weight(1f)) // se pueden poner pesos
    }
}

@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .width(300.dp)
                .height(300.dp)
                .verticalScroll(state = rememberScrollState())
                .background(Color.Blue),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(text = "Esto es un ejemplo", color = Color.White)
        }
    }
}

