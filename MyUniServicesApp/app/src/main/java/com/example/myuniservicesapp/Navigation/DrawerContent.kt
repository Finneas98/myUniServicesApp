package com.example.myuniservicesapp.Navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.myuniservicesapp.atoms.LogoutButton
import com.example.myuniservicesapp.utils.loginUser
import com.example.myuniservicesapp.utils.logoutUser
import kotlinx.coroutines.launch

@Composable
fun DrawerContent(navController: NavHostController, drawerState: DrawerState) {
    val coroutineScope = rememberCoroutineScope()
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column {
        LogoutButton(
            isLoading = isLoading,
            onLogoutClick = {
                isLoading = true
                logoutUser()
                navController.navigate("login")
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}