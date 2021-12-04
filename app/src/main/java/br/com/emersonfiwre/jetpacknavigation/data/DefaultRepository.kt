package br.com.emersonfiwre.jetpacknavigation.data

import android.content.Context
import android.util.Log
import javax.inject.Inject

class DefaultRepository @Inject constructor(
    val context: Context,
    val message: String
) : Repository {
    override fun doLogin() {
        Log.d("DefaultRepository", message)
    }
}