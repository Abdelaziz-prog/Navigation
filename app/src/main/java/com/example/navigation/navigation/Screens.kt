package com.example.navigation.navigation

import kotlinx.serialization.Serializable

@Serializable

sealed class Screens {
    @Serializable
    object Home: Screens()

    @Serializable
    object AddUser : Screens()

    @Serializable
    data class Details(val id: Int) : Screens()
}