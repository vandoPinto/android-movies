package br.com.moviestart.flixmovies.repository

import android.content.Context
import android.widget.Toast
import br.com.moviestart.flixmovies.AppResult
import br.com.moviestart.flixmovies.R
import br.com.moviestart.flixmovies.domain.User
import com.google.firebase.auth.FirebaseAuth

class RedefinirSenhaRepository(val context: Context) {

    fun redefinirSenha(email: String, callback: (result: AppResult<User>) -> Unit) {

        val auth = FirebaseAuth.getInstance()
        val emailAddress = email

        auth.sendPasswordResetEmail(emailAddress).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val email = User(
                    email = email
                )
                callback(AppResult.Success(email))
            } else {
                callback(AppResult.Error(task.exception))
            }
        }
    }
}