package br.com.moviestart.flixmovies.repository.dto.network

data class MovieDTO(
    var id: Int? = null,
    var title: String? = null,
    var overview: String? = null,
    var poster_path: String? = null
)