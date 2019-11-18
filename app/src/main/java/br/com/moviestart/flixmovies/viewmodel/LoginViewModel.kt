package br.com.moviestart.flixmovies.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.moviestart.flixmovies.domain.User

class LoginViewModel(val app: Application) : AndroidViewModel(app) {
    private val interactor = LoginInteractor(app.applicationContext)

    val password = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val result = MutableLiveData<AppResult<User>>()

    fun login() {
        //TODO: VALIDATE (NULL) EMAIL AND PASSWORD

        interactor.login(email.value!!, password.value!!) {
            result.value = it
        }

    }
}