package com.example.pratica_galeria

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pratica_galeria.ui.theme.Pratica_galeriaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pratica_galeriaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        "",
                        "",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(texto1: String, texto2: String, modifier: Modifier = Modifier) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = texto1,
                fontSize = 18.sp,
                modifier = modifier
            )
            Text(
                text = texto2,
                fontWeight = FontWeight.Bold,
                fontSize = 8.sp
            )
    }
}

data class Imagem(
    val index: Int,
    val texto1: String,
    val texto2: String
)

@Composable
fun GreetingImage(modifier: Modifier = Modifier){
    val imagens = listOf(
        Imagem(R.drawable.forest_56930_1280, "Forest in summer", "Unknown author (2024)"),
        Imagem(R.drawable.indonesia_4759317_1280, "Indonésia", "Fernanda L. (2021)"),
        Imagem(R.drawable.red_river_hog_7378106_1280, "Rio sob céu", "Luke P. (2023)")
    )

    var currentImageIndex by remember { mutableIntStateOf(0) }

    val image = imagens[currentImageIndex]

    Box(
        modifier = Modifier
    ) {


        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(id = image.index),
                contentDescription = null,
                modifier = modifier
                    .padding(30.dp)
            )
            Greeting(texto1 = image.texto1, texto2 = image.texto2)

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Button(onClick = {
                    if(currentImageIndex > 0){
                        currentImageIndex -= 1
                    }
                    else{
                        currentImageIndex = imagens.size - 1
                    }
                },
                    modifier = Modifier.size(80.dp, 30.dp),
                    contentPadding = PaddingValues(2.dp)
                ) {
                    Text(text = "Previous", fontSize = 8.sp)

                }
                Button(onClick = {
                    if(currentImageIndex < imagens.size - 1){
                        currentImageIndex += 1
                    }
                    else{
                        currentImageIndex = 0
                    }
                },
                    modifier = Modifier.size(80.dp, 30.dp),
                    contentPadding = PaddingValues(2.dp)) {
                    Text(text = "Next", fontSize = 8.sp)
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Pratica_galeriaTheme {
        GreetingImage()
    }
}