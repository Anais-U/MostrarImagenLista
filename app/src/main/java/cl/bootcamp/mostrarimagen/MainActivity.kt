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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.unit.sp

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
    var buttonText by remember { mutableStateOf("Mostrar lista de Imagenes") }

    val imageList = listOf(
        R.drawable.bienvenidos,
        R.drawable.feliz,
        R.drawable.serfeliz,
        R.drawable.felicidad,
        R.drawable.lafelicidad
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            text = "Bienvenido a mi aplicación",
            fontSize = (20.sp),
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Anais Urra",
            fontSize = (18.sp),
            style = TextStyle(fontWeight = FontWeight.Normal),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Button(onClick = {
            isImageVisible = !isImageVisible
            buttonText = if (isImageVisible) "Ocultar lista de Imagenes" else "Mostrar lista de Imagenes"
        }) {
            Text(text = buttonText)
        }

        // LazyColumn para mostrar las imágenes
        if (isImageVisible) {
            LazyColumn(modifier = Modifier.padding(top = 0.dp)) {
                items(imageList.size) { index ->
                    Image(
                        painter = painterResource(id = imageList[index]),
                        contentDescription = null,
                        modifier = Modifier
                            .size(350.dp)
                    )

                }
            }
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