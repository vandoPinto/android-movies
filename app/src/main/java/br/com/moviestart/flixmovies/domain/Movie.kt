package br.com.moviestart.flixmovies.domain

data class Movie(
    var id: Int? = null,
    var title: String? = null,
    var overview: String? = null,
    var poster_path: String? = null
)