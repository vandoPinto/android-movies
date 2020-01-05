package br.com.moviestart.flixmovies.repository

import android.content.Context
import br.com.moviestart.flixmovies.domain.Movie
import br.com.moviestart.flixmovies.repository.dto.network.MovieQueryOrderBy
import br.com.moviestart.flixmovies.repository.dto.network.MovieResultDTO
import br.com.moviestart.flixmovies.repository.mapper.MovieMapper
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.mapstruct.factory.Mappers
import retrofit2.http.GET
import retrofit2.http.Query

// EXEMPLO: https://api.themoviedb.org/3/discover/movie?api_key=6971dd639f7fd4f970ce01dcf193dc8c
interface MovieService {

    @GET("discover/movie")
    fun lastMovies(@Query("sort_by") sortBy: String): Single<MovieResultDTO>

    @GET("movie/top_rated")
    fun topRated(@Query("sort_by") sortBy: String): Single<MovieResultDTO>
}

class MovieRepository(val context: Context) :
    RetrofitBase(context, "https://api.themoviedb.org/3/") {

    private val movieService = retrofit.create(MovieService::class.java)

    fun lastMovies(sortBy: MovieQueryOrderBy): Single<Array<Movie>> {
        val domainMapper = Mappers.getMapper(MovieMapper::class.java)

        return movieService.lastMovies(sortBy.value)
            .map { result ->
                // URL FINAL EXEMPLO: http://image.tmdb.org/t/p/w500/qdfARIhgpgZOBh3vfNhWS4hmSo3.jpg
                result.movies.forEach {
                    it.poster_path = "http://image.tmdb.org/t/p/w500${it.poster_path}"
                }

                val list = mutableListOf<Movie>()

                result.movies.forEach {
                    list.add(domainMapper.toDomain(it))
                }

                list.toTypedArray()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun topRated(sortBy: MovieQueryOrderBy): Single<Array<Movie>> {
        val domainMapper = Mappers.getMapper(MovieMapper::class.java)

        return movieService.topRated(sortBy.value)
            .map { result ->
                val list = mutableListOf<Movie>()

                result.movies.forEach {
                    list.add(domainMapper.toDomain(it))
                }

                list.toTypedArray()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}