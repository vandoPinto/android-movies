package br.com.moviestart.flixmovies.viewmodel

import android.app.Application
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import br.com.moviestart.flixmovies.AppResult
import br.com.moviestart.flixmovies.R
import br.com.moviestart.flixmovies.domain.User
import br.com.moviestart.flixmovies.interactor.RedefinirSenhaIteractor

class RedefinirSenhaViewModel(val app: Application) : AndroidViewModel(app) {

    private val interactor = RedefinirSenhaIteractor(app.applicationContext)

    val preenchaCampos = this.app?.getString(R.string.preencha_campos)

    val email = MutableLiveData<String>()
    val result = MutableLiveData<AppResult<User>>()

    fun redefinirSenha() {
        if (!TextUtils.isEmpty(email.value)) {
            interactor.redefinirSenha(email.value!!) {
                result.value = it
            }
        } else {
            Toast.makeText(this.app, preenchaCampos, Toast.LENGTH_SHORT).show()
        }
    }
}
