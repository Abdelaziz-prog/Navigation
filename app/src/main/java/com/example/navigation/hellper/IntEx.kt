package com.example.navigation.hellper

import androidx.core.text.isDigitsOnly

fun String.tryToConvertToInt(): Int {
    return try {
        this.toInt()
    } catch (e: Exception) {
        0
    }
}