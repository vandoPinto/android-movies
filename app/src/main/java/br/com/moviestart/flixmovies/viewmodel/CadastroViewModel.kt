package br.com.moviestart.flixmovies.viewmodel

import android.app.Application
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import br.com.moviestart.flixmovies.AppResult
import br.com.moviestart.flixmovies.domain.User
import br.com.moviestart.flixmovies.interactor.CadastroIteractor

class CadastroViewModel(val app: Application) : AndroidViewModel(app) {

    private val interactor = CadastroIteractor(app.applicationContext)

    var name  = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val result = MutableLiveData<AppResult<User>>()

    fun cadastro() {
        if (!TextUtils.isEmpty(name.value) && !TextUtils.isEmpty(email.value) && !TextUtils.isEmpty(password.value)) {
            interactor.cadastro(name.value!!, email.value!!, password.value!!) {
                result.value = it
            }
        } else {
            Toast.makeText(this.app, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
        }
    }
}
