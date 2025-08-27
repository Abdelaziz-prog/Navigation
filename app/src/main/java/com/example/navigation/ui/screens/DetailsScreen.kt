package com.example.navigation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.navigation.data.UserDataBase
import com.example.navigation.data.UserEntity
import com.example.navigation.hellper.tryToConvertToInt
import kotlinx.coroutines.launch

@Composable
fun SecondScreen(id: Int,navController: NavController) {
    val context = LocalContext.current
    val db = remember { UserDataBase.getDataBase(context) }
    var userEntity by remember { mutableStateOf<UserEntity?>(null) }
    val userDao = db.userDao()
    val scope = rememberCoroutineScope()

    LaunchedEffect(id) {
        val user = userDao.getUserById(id)
        userEntity = user
    }

    Column(
        modifier = Modifier
            .fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Enter your Name:${userEntity?.name}",
            fontSize = 32.sp
        )
        Spacer(modifier = Modifier.padding(2.dp))
        Text(
            text = "Enter your Age:${userEntity?.age}",
            fontSize = 32.sp
        )

        Button(onClick = {
            scope.launch {
                userEntity?.let {
                    userDao.deleteUser(it)
                   navController.navigateUp()
                }

            }
        }
        ) {
            Text(text = "Delete " )
        }
    }
}