package br.com.moviestart.flixmovies.interactor

import android.content.Context
import br.com.moviestart.flixmovies.AppResult
import br.com.moviestart.flixmovies.domain.User
import br.com.moviestart.flixmovies.repository.RedefinirSenhaRepository

class RedefinirSenhaIteractor(context: Context) {
    private val redefinirSenhaRepository = RedefinirSenhaRepository(context)

    fun redefinirSenha(email: String, callback: (result: AppResult<User>) -> Unit) {
        redefinirSenhaRepository.redefinirSenha(email, callback)
    }
}