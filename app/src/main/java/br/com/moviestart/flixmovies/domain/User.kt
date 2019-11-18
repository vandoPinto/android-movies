package br.com.moviestart.flixmovies.domain

data class User (

    var id: String? = null,
    var email: String? = null,
    var password: String? = null,

    var name: String? = null,
    var telefone: String? = null,
    var dataNascimento: String? = null,
    var endereço: String? = null
)
