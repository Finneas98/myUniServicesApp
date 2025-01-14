package com.example.myuniservicesapp.organisms

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(drawerState: DrawerState, coroutineScope: CoroutineScope) {
    TopAppBar(
        title = { Text("My Uni Services") },
        navigationIcon = {
            IconButton(onClick = {
                toggleDrawer(drawerState, coroutineScope)
            }) {
                Icon(Icons.Filled.Menu, contentDescription = "Menu Icon")
            }
        }
    )
}

private fun toggleDrawer(drawerState: DrawerState, coroutineScope: CoroutineScope) {
    coroutineScope.launch {
        if (drawerState.isClosed) drawerState.open() else drawerState.close()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyTopBar() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    MyTopBar(drawerState = drawerState, coroutineScope = coroutineScope)
}


