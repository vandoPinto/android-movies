package br.com.moviestart.flixmovies.repository

import android.content.Context
import br.com.moviestart.flixmovies.AppResult
import br.com.moviestart.flixmovies.domain.User
import com.google.firebase.auth.FirebaseAuth

class LoginRepository(val context: Context) {

    fun login(email: String, password: String, callback: (result: AppResult<User>) -> Unit) {

        val auth = FirebaseAuth.getInstance()

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val firebaseUser = task.result?.user
                val user = User(
                    id = firebaseUser?.uid,
                    name = firebaseUser?.displayName,
                    email = firebaseUser?.email
                )
                callback(AppResult.Success(user))
            } else {
                callback(AppResult.Error(task.exception))
            }
        }
    }
}