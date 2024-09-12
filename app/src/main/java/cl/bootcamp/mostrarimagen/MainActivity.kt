package cl.bootcamp.mostrarimagen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cl.bootcamp.mostrarimagen.ui.theme.MostrarImagenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    var isImageVisible by remember { mutableStateOf(false) }
    var buttonText by remember { mutableStateOf("Mostrar Imagen") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Bienvenido a mi aplicación",
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Anais Urra",
            style = TextStyle(fontWeight = FontWeight.Normal),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Button(onClick = {
            isImageVisible = !isImageVisible
            buttonText = if (isImageVisible) "Ocultar Imagen" else "Mostrar Imagen"
        }) {
            Text(text = buttonText)
        }

        if (isImageVisible) {
            Image(
                painter = painterResource(id = R.drawable.bienvenidos),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .size(600.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MostrarImagenTheme {
        MainScreen()
    }
}