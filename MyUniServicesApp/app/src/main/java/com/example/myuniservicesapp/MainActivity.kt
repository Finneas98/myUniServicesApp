package com.example.myuniservicesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myuniservicesapp.Navigation.DrawerContent
import com.example.myuniservicesapp.Navigation.NavigationGraph
import com.example.myuniservicesapp.organisms.MyTopBar
import com.example.myuniservicesapp.templates.HomeScreen
import com.example.myuniservicesapp.templates.LoginScreen
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        enableEdgeToEdge()
        setContent {
            MyUniServicesApp()
        }
    }
}

@Composable
fun MyUniServicesApp(){
    var isUserLoggedIn by remember { mutableStateOf(Firebase.auth.currentUser != null) }
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    if(isUserLoggedIn){
        HomeScreen(navController)
    } else {
        LoginScreen(onLoginSuccess = {isUserLoggedIn = true}, navController = navController)
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(navController = navController, drawerState = drawerState)
        }
    ) {
        Scaffold(
            topBar = { MyTopBar(drawerState, coroutineScope) },
            content = { paddingValues ->
                MainContent(navController, paddingValues)
            }
        )
    }
}


@Composable
fun MainContent(navController: NavHostController, paddingValues: PaddingValues) {
    NavigationGraph(navController = navController, paddingValues)
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    MyUniServicesApp()
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MyUniServicesAppTheme {
//        Greeting("Android")
//    }
//}