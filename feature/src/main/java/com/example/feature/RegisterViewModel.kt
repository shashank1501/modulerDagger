package com.example.feature

import com.example.core.storage.Storage
import javax.inject.Inject

private const val REGISTERED_USER = "registered_user"
private const val PASSWORD_SUFFIX = "password"
class RegisterViewModel @Inject constructor(private val storage: Storage){

    fun registerUser(username: String, password: String) {
        storage.setString(REGISTERED_USER, username)
        storage.setString("$username$PASSWORD_SUFFIX", password)

    }
}