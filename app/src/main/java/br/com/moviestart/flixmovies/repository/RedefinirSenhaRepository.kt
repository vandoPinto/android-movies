package br.com.moviestart.flixmovies.repository

import android.content.Context
import br.com.moviestart.flixmovies.AppResult
import br.com.moviestart.flixmovies.domain.User
import com.google.firebase.auth.FirebaseAuth

class RedefinirSenhaRepository(val context: Context) {

    fun redefinirSenha(email: String, callback: (result: AppResult<User>) -> Unit) {

        val auth = FirebaseAuth.getInstance()
        val emailAddress = email

        auth.sendPasswordResetEmail(emailAddress).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val mail = User(
                    email = email
                )
                callback(AppResult.Success(mail))
            } else {
                callback(AppResult.Error(task.exception))
            }
        }
    }
}