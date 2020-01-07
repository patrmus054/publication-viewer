package com.example.inzynieria.register.data

import com.example.inzynieria.register.data.model.RegisteredInUser
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class RegisterDataSource {

    fun login(username: String, password: String): Result<RegisteredInUser> {
        try {
            // TODO: handle loggedInUser authentication
            val fakeUser = RegisteredInUser(java.util.UUID.randomUUID().toString(), "Jane Doe")
            return Result.Success(fakeUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}

