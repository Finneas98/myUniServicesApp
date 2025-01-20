package com.example.myuniservicesapp


import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.compose.AppTheme
import com.example.myuniservicesapp.navigation.DrawerContent
import com.example.myuniservicesapp.navigation.NavigationGraph
import com.example.myuniservicesapp.ui.organisms.BottomNav
import com.example.myuniservicesapp.ui.organisms.MyTopBar
import com.example.myuniservicesapp.ui.templates.HomeScreen
import com.example.myuniservicesapp.ui.templates.LoginScreen
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@Composable
fun MyUniServicesApp(){
    var isUserLoggedIn by remember { mutableStateOf(Firebase.auth.currentUser != null) }
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    AppTheme {
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
                    NavigationGraph(navController = navController, paddingValues)
                },
                bottomBar = {
                         BottomNav(navController)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    AppTheme {
        MyUniServicesApp()
    }
}