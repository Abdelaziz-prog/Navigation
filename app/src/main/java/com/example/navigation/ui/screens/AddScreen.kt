package com.example.navigation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navigation.data.UserDataBase
import com.example.navigation.data.UserEntity
import com.example.navigation.hellper.tryToConvertToInt
import com.example.navigation.navigation.Screens
import kotlinx.coroutines.launch


@Composable
fun AddNewUserScreen(navController: NavController) {
    var name by rememberSaveable { mutableStateOf("") }
    var age by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val db = remember { UserDataBase.getDataBase(context) }
    val userDao = db.userDao()
    Column(
        modifier = Modifier
            .fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        TextField(
            value = name,
            onValueChange = { name = it }, modifier = Modifier.padding(bottom = 20.dp),
            placeholder = { Text(text = "Enter your name ") }
        )
        // Spacer(modifier = Modifier.size(22.dp))
        TextField(
            value = age,
            onValueChange = { age = it }, modifier = Modifier.padding(bottom = 50.dp),
            placeholder = { Text(text = "Enter your age") }
        )
        Button(onClick = {
            scope.launch {
                val newUser = UserEntity(
                    name = name,
                    age = age.tryToConvertToInt()
                )
                userDao.addUser(newUser)

                navController.navigateUp()
            }
        }) {
            Text(text = "click me ")
        }
    }
}
