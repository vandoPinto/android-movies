package br.com.moviestart.flixmovies.interactor

import android.content.Context
import br.com.moviestart.flixmovies.AppResult
import br.com.moviestart.flixmovies.domain.User
import br.com.moviestart.flixmovies.repository.CadastroRepository

class CadastroIteractor(context: Context) {

    private val cadastroRepository = CadastroRepository(context)

    fun cadastro(name: String, email: String, password: String, callback: (result: AppResult<User>) -> Unit) {

        cadastroRepository.cadastro(name, email, password, callback)
    }
}