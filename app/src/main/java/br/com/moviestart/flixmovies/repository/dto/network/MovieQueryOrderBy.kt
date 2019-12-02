package br.com.moviestart.flixmovies.repository.dto.network

sealed class MovieQueryOrderBy(val value: String) {
    class PopularityAsc : MovieQueryOrderBy("popularity.asc")
    class PopularityDesc : MovieQueryOrderBy("popularity.desc")
    class ReleaseDateAsc : MovieQueryOrderBy("release_date.asc")
    class ReleaseDateDesc : MovieQueryOrderBy("release_date.desc")
}