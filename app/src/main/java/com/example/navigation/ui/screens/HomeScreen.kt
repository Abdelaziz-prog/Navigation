package com.example.navigation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navigation.data.entities.UserEntity
import com.example.navigation.navigation.Screens

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screens.AddUser)
                }
            ) {
                Text("+")
            }
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(10, ) {
                UserItem(
                    user = UserEntity(
                        name = "aa",
                        age = it

                    )
                )
            }
        }

    }
}


@Composable
fun UserItem(modifier: Modifier = Modifier, user: UserEntity) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            Text(text = user.name, color = Color.Black)
            Text(text = user.age.toString(), color = Color.Black)
        }
    }
}