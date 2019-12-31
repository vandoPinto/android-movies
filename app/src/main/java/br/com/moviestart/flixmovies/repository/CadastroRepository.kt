package br.com.moviestart.flixmovies.repository

import android.content.Context
import android.os.Handler
import android.widget.Toast
import br.com.moviestart.flixmovies.AppResult
import br.com.moviestart.flixmovies.domain.User
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class CadastroRepository(val context: Context) {

    private val auth = FirebaseAuth.getInstance()
    private val database = FirebaseDatabase.getInstance()

    fun cadastro(name: String, email: String, password: String, callback: (result: AppResult<User>) -> Unit) {

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task: Task<AuthResult> ->
            if (task.isSuccessful) {
                val user = User(
                    name = name,
                    email = email,
                    password = password
                )
                saveUser(name)
                callback(AppResult.Success(user))
            } else {
                callback(AppResult.Error(task.exception))
            }
        }
    }

    private fun saveUser(name: String) {
        val user = FirebaseAuth.getInstance().currentUser

        Handler().postDelayed({
            if (user != null) {
                val UserMovieFliex = database.getReference(user.uid)
                UserMovieFliex.setValue(name)
            } else {
                Toast.makeText(this.context, "Error updateUI", Toast.LENGTH_SHORT).show()
            }
        }, 5000)
    }
}