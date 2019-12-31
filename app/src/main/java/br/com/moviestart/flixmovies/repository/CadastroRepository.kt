package br.com.moviestart.flixmovies.repository

import android.content.Context
import android.text.TextUtils
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
    private val user = FirebaseAuth.getInstance().currentUser

    fun cadastro(name: String, email: String, password: String, callback: (result: AppResult<User>) -> Unit) {

        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {

            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task: Task<AuthResult> ->
                if (task.isSuccessful) {
                    saveUser(name)
                    Toast.makeText(this.context, "Cadastro criado com sucesso", Toast.LENGTH_SHORT).show()

                } else {
                    Toast.makeText(this.context, "Erro ao tentar criar a conta", Toast.LENGTH_SHORT).show()
                    callback(AppResult.Error(task.exception))
                }
            }

        } else {
            Toast.makeText(this.context, "Tente novamente", Toast.LENGTH_SHORT).show()
        }
    }

    fun saveUser(name: String) {
        if (user != null) {
            val UserMovieFlix = database.getReference(user.uid)
            UserMovieFlix.setValue(name)
        }
    }
}