package com.example.daggermodules

import com.example.core.storage.Storage
import javax.inject.Inject

private const val REGISTERED_USER = "registered_user"
private const val PASSWORD_SUFFIX = "password"
class MainViewModel @Inject constructor(private val storage: Storage) {

    val username: String
        get() = storage.getString(REGISTERED_USER)

    fun loginUser(username: String, password: String): Boolean {
        val registeredUser = this.username
        if (registeredUser != username) return false

        val registeredPassword = storage.getString("$username$PASSWORD_SUFFIX")
        if (registeredPassword != password) return false


        return true
    }

}