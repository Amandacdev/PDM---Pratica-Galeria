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

@Composable
fun GreetingImage(currentImageIndex: Int, modifier: Modifier = Modifier){
    val images = listOf(
        R.drawable.forest_56930_1280,
        R.drawable.indonesia_4759317_1280,
        R.drawable.red_river_hog_7378106_1280
    )
    val image = painterResource(images[currentImageIndex])

    Box(
        modifier = Modifier
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .padding(30.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Pratica_galeriaTheme {

        var currentImageIndex by remember {  mutableStateOf(0) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp, 2.dp, 8.dp, 2.dp)
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                GreetingImage(currentImageIndex = currentImageIndex)
                Greeting("Forest in summer",
                "Unknown author (2024)")

                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Button(onClick = {
                        if (currentImageIndex > 0) {
                            currentImageIndex -= 1
                        }
                    },
                        modifier = Modifier.size(80.dp, 30.dp),
                        contentPadding = PaddingValues(2.dp)
                    ) {
                        Text(text = "Previous", fontSize = 8.sp)

                    }
                    Button(onClick = {
                        currentImageIndex = (currentImageIndex + 1) % 3
                    },
                            modifier = Modifier.size(80.dp, 30.dp),
                            contentPadding = PaddingValues(2.dp)) {
                            Text(text = "Next", fontSize = 8.sp)
                    }
                }
            }
        }
    }
}