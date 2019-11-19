package br.com.moviestart.flixmovies.interactor

import android.content.Context
import br.com.moviestart.flixmovies.AppResult
import br.com.moviestart.flixmovies.domain.User
import br.com.moviestart.flixmovies.repository.LoginRepository

class LoginInteractor(context: Context) {

    private val loginRepository = LoginRepository(context)

    fun login(email: String, password: String, callback: (result: AppResult<User>) -> Unit) {

        //TODO: Validate email and password

        loginRepository.login(email, password, callback)
    }
}