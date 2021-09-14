package com.eduvy.demo.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

class SessionManager  @SuppressLint("CommitPrefEdits") constructor(private val context: Context)  {

    private val pref: SharedPreferences
    private val editor: SharedPreferences.Editor
    private val TOKEN = "api_token"
    /*set token*/
    var token: String?
        get() = pref.getString(TOKEN, "")
        set(token) {
            editor.putString(TOKEN, token)
            editor.apply()
        }
    companion object {
        private const val PREF_NAME = "Ecommerce_Session"
    }
    init {
        // Shared pref mode
        val PRIVATE_MODE = 0
        pref = context.getSharedPreferences(
            PREF_NAME,
            PRIVATE_MODE
        )
        editor = pref.edit()
    }
}