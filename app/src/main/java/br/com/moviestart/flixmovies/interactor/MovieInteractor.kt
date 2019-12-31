package br.com.moviestart.flixmovies.interactor

import android.content.Context
import br.com.moviestart.flixmovies.domain.Movie
import br.com.moviestart.flixmovies.repository.MovieRepository
import br.com.moviestart.flixmovies.repository.dto.network.MovieQueryOrderBy
import io.reactivex.Single

class MovieInteractor(context: Context) {

    private val movieRepository = MovieRepository(context)

    fun lastMovies(sortBy: MovieQueryOrderBy): Single<Array<Movie>> {
        return movieRepository.lastMovies(sortBy)
    }

    fun topRated(sortBy: MovieQueryOrderBy): Single<Array<Movie>> {
        return movieRepository.topRated(sortBy)
    }
}