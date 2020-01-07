package com.example.inzynieria.register.data.model

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class RegisteredInUser(
    val userId: String,
    val displayName: String
)
