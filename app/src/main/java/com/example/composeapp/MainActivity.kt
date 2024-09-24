package com.example.composeapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.composeapp.ui.components.MyListItem
import com.example.composeapp.ui.screens.CalendarScreen
import com.example.composeapp.ui.screens.HomeScreen
import com.example.composeapp.ui.screens.SettingsScreen
import com.example.composeapp.ui.theme.ComposeAppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeAppTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    NavHost(
                        navController = navController,
                        startDestination = "Home"
                    ) {
                        composable(route = "Home") {
                            HomeScreen(navController)
                        }
                        composable(route = "Settings") {
                            SettingsScreen()
                        }
                        composable(route = "Calendar") {
                            CalendarScreen()
                        }
                    }
                }
            }
        }
    }
}

//Column
@Composable
fun MyColumn() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(text = "Ejemplo 1", modifier = Modifier.background(Color.Red))
        Text(text = "Ejemplo 2", modifier = Modifier.background(Color.Green))
        Text(text = "Ejemplo 3", modifier = Modifier.background(Color.Gray))
        Text(text = "Ejemplo 4", modifier = Modifier.background(Color.Blue))
    }
}

//Row
@Composable
fun MyRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
    ) {
        Text(
            text = "Ejemplo 1",
            modifier = Modifier
                .background(Color.Red)
                .width(100.dp)
                .height(200.dp)
        )

        Text(
            text = "Ejemplo 2",
            modifier = Modifier
                .background(Color.Gray)
                .width(100.dp)
                .height(200.dp)
        )
        Text(
            text = "Ejemplo 3",
            modifier = Modifier
                .background(Color.Blue)
                .width(100.dp)
                .height(200.dp)
        )
        Text(
            text = "Ejemplo 4",
            modifier = Modifier
                .background(Color.Cyan)
                .width(100.dp)
                .height(200.dp)
        )
        Text(
            text = "Ejemplo 5",
            modifier = Modifier
                .background(Color.Green)
                .width(100.dp)
                .height(200.dp)
        )
        Text(
            text = "Ejemplo 6",
            modifier = Modifier
                .background(Color.Black)
                .width(100.dp)
                .height(200.dp)
        )
    }
}

@Composable
fun MyBox() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(50.dp))
                .background(Color.Cyan)
                .width(200.dp)
                .height(200.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Hola a todos")
        }
    }
}

@Composable
fun MyComplexLayout() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        //1. Box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.333f)
                .background(Color.Cyan)
        )
        //2. Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.333f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.5f)
                    .background(Color.Yellow),
                contentAlignment = Alignment.BottomEnd
            ) {
                Text(text = "Hola a todos")
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.5f)
                    .background(Color.Green),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Hola a todos")
            }
        }
        //3. Box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.333f)
                .background(Color.Magenta)
        )
    }
}

@Composable
fun MyList() {
    val foodList = listOf("Hamburguesa", "Papas", "Tacos", "Sushi", "Ensalada", "Pozole")

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp)
    ) {
        items(foodList) { food ->
            MyListItem(food = food)
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun Tarea01() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.2f)
                .background(Color.Cyan),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Encabezado",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.3f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Color.Yellow)
                    .weight(0.5f),
                contentAlignment = Alignment.Center
            ) {
                Column {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Caja 1 ",
                            modifier = Modifier.padding(20.dp),
                            fontSize = 24.sp
                        )
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(30.dp))
                                .background(Color.Blue)
                        ) {
                            Text(
                                text = "Accion",
                                modifier = Modifier
                                    .padding(start = 30.dp)
                                    .padding(end = 30.dp)
                                    .padding(top = 20.dp)
                                    .padding(bottom = 20.dp), fontSize = 20.sp,
                                color = Color.White
                            )
                        }
                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Color.Green)
                    .weight(0.5f),
                contentAlignment = Alignment.Center

            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Caja 2 ",
                        modifier = Modifier.padding(20.dp),
                        fontSize = 24.sp
                    )
                    Box(

                        modifier = Modifier
                            .clip(RoundedCornerShape(30.dp))
                            .background(Color.Blue)
                    ) {
                        Text(
                            text = "Accion",
                            modifier = Modifier
                                .padding(start = 30.dp)
                                .padding(end = 30.dp)
                                .padding(top = 20.dp)
                                .padding(bottom = 20.dp), fontSize = 20.sp,
                            color = Color.White
                        )
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth()
                .weight(0.3f)
        ) {
            Column {
                Text(
                    text = "Lista de Elementos",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()

                )
                MyList()
            }


        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.2f)
                .background(Color.Magenta),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Pie de Página",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun MyStateExample() {
    //Guarda el estado en una orientacion, pero si se recontruye el componente completo se regresa al estado inicial
//    var counter by remember {
//        mutableStateOf(0)
//    }
//    var counter by rememberSaveable {
//        mutableStateOf(0)
//    }
    val counter = rememberSaveable {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        Text(text = "El valor del contador es: ${counter}")
//        Button(onClick = { counter++ }) {
//            Text(text = "Incrementar")
//        }
        Text(text = "El valor del contador es: ${counter.value}")
        Row(
            modifier = Modifier.padding(20.dp)
        ) {
            Button(onClick = { counter.value-- }, modifier = Modifier.padding(end = 20.dp)) {
                Text(text = "Decrementar")
            }
            Button(onClick = { counter.value++ }) {
                Text(text = "Incrementar")
            }
        }
    }
}

@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = "https://cms.w2m.com/dam/Sites/Flowo/imagenes-blog/blog/cancun-o-riviera-maya-cual-es-mejor.jpg"),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Text(text = "Hola")

//            AsyncImage(model = ImageRequest.Builder(LocalContext.current).data("https://cms.w2m.com/dam/Sites/Flowo/imagenes-blog/blog/cancun-o-riviera-maya-cual-es-mejor.jpg").build(), contentDescription = null,
//                modifier = Modifier.fillMaxSize().height(200.dp))
        }

    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_7_PRO
)

@Composable
fun GreetingPreview() {
    ComposeAppTheme {
        MyCard()
    }
}